package Subsequence;

import java.util.HashMap;
import java.util.Map;
//https://leetcode.cn/problems/number-of-longest-increasing-subsequence/
public class demo3 {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int []dp = new int [n];//dp[i]:i位置为结尾的所有子序列中最长的长度
        int []dp2 = new int [n];//dp2[i]:i位置为结尾的最长递增子序列的个数
        for(int i = 0;i < n;i++) dp[i] = dp2[i] = 1;
        int ret = 1;
        for(int i = 1;i < n;i++){
            for(int j = i-1;j >= 0;j--){
                if(nums[i] > nums[j]){//构成递增
                    if(dp[j] + 1 > dp[i]){
                        dp[i] = dp[j]+1;
                        dp2[i] = dp2[j];
                    }else if(dp[j] + 1 == dp[i]){
                        dp2[i] += dp2[j];//累加相同长度的路径
                    }
                }
            }
            ret = Math.max(ret,dp[i]);//记录最长的长度
        }
        int cnt = 0;
        for(int i = 0;i < n;i++){
            if(dp[i] == ret){
                cnt += dp2[i];
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int []nums = {1,3,5,4,7};
        int x = new demo3().findNumberOfLIS(nums);
        System.out.println(x);
    }
}
