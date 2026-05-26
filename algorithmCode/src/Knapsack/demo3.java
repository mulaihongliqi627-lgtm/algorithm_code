package Knapsack;

public class demo3 {
    public int findTargetSumWays(int[] nums, int target) {
        int n =nums.length;
        int sum = 0;
        for(int x : nums) sum += x;
        int key = (sum + target)/2;
        if((sum + target)% 2 == 1 || Math.abs(target) > sum) return 0;//凑不出
        int []dp = new int [key + 1];//dp[j]:能凑出j的方案数
        dp[0] = 1;//凑出0容量的背包只需要什么都不选即可
        for(int i = 0;i < n;i++){
            for(int j = key;j >= nums[i];j--){//只需要遍历到nums[i],j < nums[i]时说明背包装不下无需遍历
                dp[j] = dp[j] + dp[j - nums[i]];//总方案数=不选的方案个数 + 选了之后,前面能凑出剩余容量的方案数
            }
        }
        return dp[key];
    }
}
