package subarray;

public class demo3 {
    public int maxProduct(int[] nums) {
        //dp[i]:以i位置为结尾的最大乘积子数组
        int n = nums.length;
        if(n == 1) return nums[0];
        int []dp = new int[n+1];
        int []dp2 = new int [n+1];
        int ret = Integer.MIN_VALUE,ret2 = Integer.MAX_VALUE;
        for(int i = 1;i <= n;i++){
            int x = nums[i-1];
            int y = nums[i-1] * dp[i-1];
            int z = nums[i-1] * dp2[i-1];
            dp[i] = Math.max(x,Math.max(y,z));
            dp2[i] = Math.min(x,Math.min(y,z));
            ret = Math.max(ret,dp[i]);
        }
        return ret;
    }

    public static void main(String[] args) {
        int []nums = {-2,3,-4};
        int x = new demo3().maxProduct(nums);
        System.out.println(x);
    }
}
