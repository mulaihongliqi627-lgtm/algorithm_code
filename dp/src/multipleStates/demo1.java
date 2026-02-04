package multipleStates;

import com.sun.tools.javac.Main;

//题目链接：https://leetcode.cn/problems/house-robber-ii/description/
public class demo1 {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        return Math.max(nums[0] + rob1(nums,2,n-2),rob1(nums,1,n-1));
    }
    public int rob1(int []nums,int left,int right){
        int []f = new int[nums.length];
        int []g = new int[nums.length];
        for(int i = left;i <= right;i++){
            f[i] = g[i-1] + nums[i];
            g[i] = Math.max(f[i-1],g[i-1]);
        }
        return Math.max(f[right],g[right]);
    }

    public static void main(String[] args) {
        int []nums = {1,2,3,1};
        int ret = new demo1().rob(nums);
        System.out.println(ret);
    }
}
