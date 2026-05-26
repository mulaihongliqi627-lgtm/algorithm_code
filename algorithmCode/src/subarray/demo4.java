package subarray;
//https://leetcode.cn/problems/maximum-length-of-subarray-with-positive-product/submissions/698856342/
public class demo4 {
    public int getMaxLen(int[] nums) {
        //dp1[i]:所有以i结尾的⼦数组，乘积为正数的最⻓⼦数组的⻓度
        //dp2[i]:所有以i结尾的⼦数组，乘积为负数的最⻓⼦数组的⻓度
        int n = nums.length;
        int []dp1 = new int [n+1];
        int []dp2 = new int [n+1];
        int len = 0;
        for(int i = 1;i <= n;i++){
            if(nums[i-1] == 0){
                dp1[i] = 0;
                dp2[i] = 0;
            }
            else if(nums[i-1] > 0){//当前的数大于0
                dp1[i] = dp1[i-1] + 1;
                dp2[i] = dp2[i-1] > 0 ? dp2[i-1] + 1 : 0;//i-1存在乘积最大的负序列。与nums[i]位置相乘只会使负序列数组长度增加
            }
            else if(nums[i-1] < 0){
                dp2[i] = dp1[i-1] + 1;
                dp1[i] = dp2[i-1] > 0 ? dp2[i-1] + 1 : 0;
            }
            len = Math.max(dp1[i],len);
        }
        return len;
    }

    public static void main(String[] args) {
        int []nums = {1,-2,-3,4};
        int x = new demo4().getMaxLen(nums);
        System.out.println(x);
    }
}
