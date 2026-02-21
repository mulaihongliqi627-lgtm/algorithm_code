package Subsequence;
//https://leetcode.cn/problems/wiggle-subsequence/
public class demo2 {
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        int []f = new int [n];//f[i]:以i位置为结尾,最后为上升的最长子序列的长度
        int []g = new int [n];//下降
        for(int i = 0;i < n;i++) f[i]=g[i]=1;//初始化
        int ret = 1;
        for(int i = 1;i < n;i++){
            for(int j = i-1;j >= 0;j--){
                if(nums[i] > nums[j]){
                    f[i] = Math.max(f[i],g[j]+1);
                }else if(nums[i] < nums[j]){
                    g[i] = Math.max(g[i],f[j] +1);
                }
            }
            ret = Math.max(ret,Math.max(f[i],g[i]));
        }
        return ret;
    }

    public static void main(String[] args) {
        int []nums = {1,17,5,10,13,15,10,5,16,8};
        int x = new demo2().wiggleMaxLength(nums);
        System.out.println(x);
    }
}
