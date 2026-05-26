package subarray;

import java.util.Scanner;
//最大连续子列和问题
public class demo9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int[] dp = new int[n];
        dp[0] = nums[0];
        //dp[i]：以i位置结尾的子序列中的最大子列和
        int sum = 0;
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i] = dp[i-1] + nums[i],dp[i] = nums[i]);
            sum = Math.max(sum,dp[i]);
        }
        System.out.println(sum > 0 ? sum : 0);
    }
}
