package subarray;
//https://leetcode.cn/problems/arithmetic-slices/
public class demo5 {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        //dp[i] : 以i位置为结尾的数组中存在多少个等差数组
        int []dp = new int [n+1];
        int ret = 0;
        for(int i = 3;i <= n;i++){
            if(nums[i-1] + nums[i-3] != 2 * nums[i-2]){//无法构成等差数列
                dp[i] = 0;
            }else{
                dp[i] = dp[i-1] + 1;
                ret += dp[i];
            }
        }
        return ret;
    }
    public static void main(String[] args) {
        int []nums = {1,2,3,4};
        int x = new demo5().numberOfArithmeticSlices(nums);
        System.out.println(x);
    }
}
