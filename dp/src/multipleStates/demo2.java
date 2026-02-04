package multipleStates;

//题目链接:https://leetcode.cn/problems/the-masseuse-lcci/
public class demo2 {
    public int massage(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        int []f = new int [n+1];//f[i]:表示以i位置选择时的最大时长
        int []g=  new int [n+1];//g[i]表示以i位置不选择时的最大时长
        f[0] = nums[0];
        for(int i = 1;i < n;i++){
            f[i] = nums[i] + g[i-1];//当前位置选择，前一个不选
            g[i] = Math.max(f[i-1],g[i-1]);
        }
        return Math.max(f[n-1],g[n-1]);
    }
}
