package Subsequence;

public class demo1 {
    //子序列不要求连续
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int []dp = new int [n];
        //dp[i]:以i为结尾的所有递增子序列的最长的长度
        for(int i = 0;i < n;i++) dp[i] = 1;//初始化
        int len = 1;
        for(int i = 1;i < n;i++){
            for(int j = i-1;j >= 0;j--){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[j]+1,dp[i]);
                    len = Math.max(dp[i],len);
                }
            }
        }
        return len;
    }
    public static void main(String[] args) {
        int []nums = {10,9,2,5,3,7,101,18};
        int x = new demo1().lengthOfLIS(nums);
        System.out.println(x);
    }
}
