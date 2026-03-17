package Knapsack;

//01背包
//https://leetcode.cn/problems/partition-equal-subset-sum/
public class demo2 {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int i = 0;i < n;i++) sum += nums[i];
        if(sum % 2 == 1) return false;
        int key = sum / 2;
        //使用一维滚动数组优化
        boolean []dp = new boolean[key + 1];//dp[j]能否凑出j(目标和)
        for(int i = 0;i <= n;i++){
            dp[0] = true;//0不选就能凑出来
        }
        for(int i = 1;i <= n;i++){
            for(int j = key;j >= 0;j--){
                if(j >= nums[i-1]){//背包能装下
                    dp[j] = dp[j] || dp[j - nums[i-1]];//减去这个数后的剩余容量是否能被凑齐
                }else{//装不下
                    dp[j] = dp[j];
                }
            }
        }
        return dp[key];
    }
}
