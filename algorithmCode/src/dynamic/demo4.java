package dynamic;

import java.util.Arrays;

public class demo4 {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        Arrays.sort(nums);
        int len = 1;
        int maxLen = 1;
        for(int i = 1;i < n;i++){
            if(nums[i] == nums[i-1]+1){
                len++;
            }else if(nums[i] != nums[i-1]){//遇到重复元素时，跳过，不重新计数
                len = 1;
            }
            maxLen = Math.max(len,maxLen);
        }
        return maxLen;
    }

    //动态规划
    public int longestConsecutive2(int[] nums) {
        if (nums.length == 0) return 0;

        Arrays.sort(nums);
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = 1;
        int maxLen = 1;

        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[i-1] + 1) {
                dp[i] = dp[i-1] + 1;
            } else if (nums[i] == nums[i-1]) {
                dp[i] = dp[i-1];  // 重复元素，继承前面的长度
            } else {
                dp[i] = 1;  // 不连续，重新开始
            }
            maxLen = Math.max(maxLen, dp[i]);
        }

        return maxLen;
    }


    public static void main(String[] args) {
        System.out.println(new demo4().longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1}));
    }
}
