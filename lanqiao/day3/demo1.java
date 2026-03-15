package day3;

import java.util.Scanner;

//动态规划,数组分割
public class demo1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //在此输入您的代码...
        int T = scan.nextInt();
        while(T-- > 0){
            int n = scan.nextInt();
            long []arr = new long [n];
            long sum = 0;
            for(int i = 0;i < n;i++){
                arr[i] = scan.nextLong();
                sum += arr[i];
            }
            if(sum % 2 == 1){
                System.out.println(0);//总和为奇数不能被划分为两个和为偶数的子数组
            }else{
                long ret = fn(arr);
                System.out.println(ret);
            }
        }

        scan.close();
    }

    public static long fn(long []arr){
        long[]dp = new long[2];//使用滚动数组dp[0]:arr[i]->dp[0]:以i为结尾的所有子数组中和为偶数的方案书,arr[i]->dp[1],....和为奇数
        dp[0] = 1;// 初始时为1
        for(int i = 0;i < arr.length;i++){
            long x = dp[0];//和为偶数的方案数
            long y  =dp[1];//何为奇数的方案数
            if(arr[i] % 2 == 0){//当前元素是偶数,放哪边都无影响
                dp[0] = (x * 2)%1000000007;//状态翻倍
                dp[1] = (y * 2) % 1000000007;
            }else{//是奇数,状态改变
                dp[0] = (x + y)%1000000007;//为了得到该位置的偶数和,前一个状态的偶数方案数(不放) + 前一个状态的奇数方案数(放nums[i],变为奇数)
                dp[1] = (y + x)%1000000007;//为了得到该位置的奇数和,前一个状态的奇数方案数(不放) + 前一个状态的偶数方案数(放nums[i],变为奇数)
            }
        }
        return dp[0];
    }
}
