package subarray;

//https://leetcode.cn/problems/maximum-sum-circular-subarray/
public class demo2 {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int x:nums){
            sum += x;
        }
        if(n == 1) return nums[0];
        int []dp = new int [n+1];
        int ret = Integer.MIN_VALUE;
        //找出最长的子数组
        for(int i = 1;i <= n;i++){
            dp[i] = Math.max(nums[i-1],nums[i-1] + dp[i-1]);
            ret = Math.max(ret,dp[i]);
        }
        int []dp2 = new int [n+1];
        int ret2 = Integer.MAX_VALUE;
        //找出最短的子数组
        for(int i = 1;i <= n;i++){
            dp2[i] = Math.min(nums[i-1],nums[i-1] + dp2[i-1]);
            ret2 = Math.min(ret2,dp2[i]);
        }
        int x = sum - ret2;//最短子数组为其自身时，x = 0，此时返回ret

        return x == 0 ? ret : Math.max(x,ret);
    }

    public static void main(String[] args) {
        int [] nums = {-3,-2,-3};
        int x = new demo2().maxSubarraySumCircular(nums);
        System.out.println(x);
    }
}
