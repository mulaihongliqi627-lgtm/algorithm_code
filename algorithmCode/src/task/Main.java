package task;

import java.util.Scanner;

public class Main {
//    public static void main1(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] nums = new int[n];
//        for (int i = 0; i < n; i++) {
//            nums[i] = sc.nextInt();
//        }
//        int[] dp = new int[n];
//        dp[0] = nums[0];
//        //dp[i]：以i位置结尾的子序列中的最大子列和
//        int sum = 0;
//        for (int i = 1; i < n; i++) {
//            dp[i] = Math.max(dp[i] = dp[i-1] + nums[i],dp[i] = nums[i]);
//            sum = Math.max(sum,dp[i]);
//        }
//        System.out.println(sum > 0 ? sum : 0);
//    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        double n = sc.nextDouble();
        double sum = 0;
        int y = 1;
        for(int i = x;i >= 0;i--){
            double ret = (double)Math.pow(n,i) * y++;
            sum += ret;
        }
        System.out.printf("%.3f\n",sum);
    }
}