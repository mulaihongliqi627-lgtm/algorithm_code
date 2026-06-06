package dynamic;

//https://leetcode.cn/problems/maximum-product-subarray/description/
public class demo5 {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        int []dp1 = new int [n+1];//大
        int []dp2 = new int [n+1];//小
        int ret = Integer.MIN_VALUE;
        for(int i = 1;i <= n;i++){
            int x = nums[i-1];
            int y = x * dp1[i-1];//情况1:乘前面保存的状态最大值
            int z = x * dp2[i-1];//情况2:乘前面保存状态的最小值
            dp1[i] = Math.max(x,Math.max(y,z));
            dp2[i] = Math.min(x,Math.min(y,z));
            ret = Math.max(dp1[i],ret);//从dp1表中的最大值取舍
        }
        return ret;
    }

    public int maxProduct2(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];

        // 用三个变量代替原本的 dp 数组
        int maxVal = nums[0]; // 最大乘积
        int minVal = nums[0]; // 最小乘积
        int ret = nums[0];    // 全局最大值

        for (int i = 1; i < n; i++) {
            int x = nums[i];

            // 三种可能的结果
            int a = x;
            int b = maxVal * x;
            int c = minVal * x;
            maxVal = Math.max(a, Math.max(b, c));
            minVal = Math.min(a, Math.min(b, c));

            // 更新全局最大值
            ret = Math.max(ret, maxVal);
        }

        return ret;
    }
}
