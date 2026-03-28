package day6;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//长草问题,bfs广度优先遍历
public class demo1 {
    static int []dx = {1,-1,0,0};
    static int []dy = {0,0,1,-1};
    static int n,m,k;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //在此输入您的代码...
        n = scan.nextInt();
        m = scan.nextInt();
        char[][] arr = new char[n][m];
        Queue<int []> queue = new LinkedList<>();//int []{i,j,k}横纵坐标+当前月份
        for(int i = 0;i < n;i++){
            String line = scan.next();
            for(int j = 0;j < m;j++){
                arr[i][j] = line.charAt(j);
                if(arr[i][j] == 'g'){
                    queue.add(new int []{i,j,0});//入队列,最初还未生长,月份为0
                }
            }
        }
        int k = scan.nextInt();

        while(!queue.isEmpty()){
            int []tmp = queue.poll();//获取队首元素
            //一轮四次
            if(tmp[2] == k) continue;//到达月份限制
            for(int i = 0;i < 4;i++){
                int x = dx[i] + tmp[0],y = dy[i] + tmp[1];
                int curMonth = tmp[2];
                if(x >= 0 && x < n && y >= 0 && y < m && arr[x][y] == '.'){
                    arr[x][y] = 'g';//空地长草
                    queue.add(new int []{x,y,curMonth + 1});
                }
            }
        }

        for(int i = 0;i < n;i++){
            String s = new String(arr[i]);
            System.out.println(s);
        }
        scan.close();
    }


}
