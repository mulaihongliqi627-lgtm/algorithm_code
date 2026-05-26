package subarray;
//https://leetcode.cn/problems/maximum-subarray/description/


public class demo1 {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        int []dp = new int [n+1];
        //dp[i]:以i位置为结尾的最大的子数组之和
        int ret = Integer.MIN_VALUE;
        for(int i = 1;i <= n;i++){
            dp[i] = Math.max(nums[i-1],dp[i-1] + nums[i-1]);
            ret = Math.max(ret,dp[i]);
        }
        return ret;
    }
    public static void main(String[] args) {
        int []nums = {5,4,-1,7,8};
        int ret = new demo1().maxSubArray(nums);
        System.out.println(ret);
    }
}
