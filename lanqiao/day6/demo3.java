package day6;

import java.util.Locale;
import java.util.Scanner;

public class demo3 {
    static int count = 0;
    static boolean[]visit = new boolean[10];
    static int []path = new int [10];//当前排列
    static int N;
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        N = n;
        dfs(0);//生成1-9全排列
        System.out.println(count);
    }

    public static void dfs(int x){
        if(x == 9){//生成了一种全排列
            check();
            return;
        }
        for(int i = 1;i <= 9;i++){
            if(!visit[i]){
                path[x] = i;
                visit[i] = true;
                dfs(x+1);
                visit[i] = false;
            }
        }
    }
    //检查当前的排列是否可以组成带分数的形式
    static void check(){
        for(int i = 0;i < 7;i++){
            long a = getNum(0,i);
            if(a >= N) return;//负数,舍去
            for(int j = i + 1;j < 8;j++){
                long b = getNum(i + 1,j);
                long c = getNum(j + 1,8);
                if(b == c * (N - a)){//可以凑成带分数的形式表示
                    count++;
                }
            }
        }
    }
    //从全排列的数组中截取得到一个数
    static long getNum(int l,int r){
        long ret = 0;
        for(int i = l;i <= r;i++){
            ret = 10 * ret + path[i];
        }
        return  ret;
    }
}
