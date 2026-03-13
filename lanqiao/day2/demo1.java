package day2;

import java.util.Arrays;
import java.util.Scanner;

//蓝桥杯真题,三国问题,使用贪心算法
public class demo1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //处理输入
        int n = scan.nextInt();
        int []a = new int[n];
        int []b = new int[n];
        int []c = new int[n];
        for(int i = 0;i < n;i++){
            a[i] = scan.nextInt();
        }
        for(int i = 0;i < n;i++){
            b[i] = scan.nextInt();
        }
        for(int i = 0;i < n;i++){
            c[i] = scan.nextInt();
        }

        //计算每个国家需要获胜需要的最大事件数,取max
        int winA = fn(a,b,c,n);
        int winB = fn(b,a,c,n);
        int winC = fn(c,a,b,n);

        //对每个国家获胜所需的最大事件数取最大值,拿到打胜仗次数最多的
        int winFin = Math.max(winA,Math.max(winB,winC));
        if(winFin <= 0){
            System.out.println(-1);
        }else{
            System.out.println(winFin);
        }
        scan.close();
    }

    //me战胜其他两国所需要的最大事件数
    public static int fn(int []me,int []enemy1,int []enemy2,int n){
        int []w = new int [n];//w[i]:第i次和其他两国交战后的剩余兵力,为负说明不利
        for(int i=0;i < n;i++){
            w[i] = me[i] - enemy1[i] - enemy2[i];//我方兵力减去其他两国兵力,X>Y+Z -> X- Y -Z > 0
        }
        //排序
        Arrays.sort(w);
        //贪心
        long sum = 0;
        int count = 0;//能一直打胜仗的事件数
        for(int i = n-1;i >= 0;i--){//倒序加,先加最大的
            sum += (long)w[i];//累加,计算每次和其余军队对战的战况
            if(sum <= 0){
                break;//已经输了,后面的都输必输局,没必要打了
            }else{
                count++;
            }
        }
        return count;
    }
}
