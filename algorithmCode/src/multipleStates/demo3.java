package multipleStates;

import java.util.Arrays;
//https://leetcode.cn/problems/delete-and-earn/submissions/696741806/

public class demo3 {
    public int deleteAndEarn(int[] nums) {
        Arrays.sort(nums);
        int []hash = new int [10001];
        for(int i = 0;i < nums.length;i++){
            hash[nums[i]]++;
        }
        int []f = new int [20001];//i选
        int []g = new int [20001];//i不选
        for(int i = 0;i < nums.length;i++){
            f[i] = g[i-1] + nums[i];
            g[i] = Math.min(f[i-1],g[i-1]);
        }
        return Math.max(f[nums.length-1],g[nums.length-1]);
    }
}
