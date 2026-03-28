package day11;

import java.util.*;

//滑动窗口
//https://www.luogu.com.cn/problem/P8661
public class demo2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int d = sc.nextInt();
        int k = sc.nextInt();
        int [][]logs = new int [n][2];
        for(int i = 0;i < n;i++){
            logs[i][0] = sc.nextInt();//ts
            logs[i][1] = sc.nextInt();//id
        }
        Arrays.sort(logs,(a,b) -> a[0] - b[0]);//按时间升序排列
        int i = 0;
        int []getKey = new int[100005];//记录对应的id获赞个数
        boolean []isHot = new boolean[100005];//对应id是否是热度id
        for(int j = 0;j < n;j++){
            int rightID = logs[j][1];
            getKey[rightID]++;//获赞增加
            while (logs[j][0] - logs[i][0] >= d){//超出时间范畴,左边出窗口
                getKey[logs[i][1]]--;//对应id的有效获赞数减1
                i++;//窗口左边界右移
            }
            //此时排除了规定之外的点赞记录,开始检测是否构成热榜
            if(getKey[rightID] >= k){//满足
                isHot[rightID] = true;
            }
        }
        for(int j = 0;j < 100005;j++){
            if(isHot[j]){
                System.out.println(j);
            }
        }
    }

}
