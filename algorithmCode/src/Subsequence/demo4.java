package Subsequence;

import java.util.Arrays;
//https://leetcode.cn/problems/maximum-length-of-pair-chain/
public class demo4 {
    public int findLongestChain(int[][] pairs) {
        int n = pairs.length;
        int []dp = new int [n];
        Arrays.fill(dp,1);//初始化
        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);//排序
        int ret = 1;
        for(int i = 1;i < n;i++){
            for(int j = 0;j < i;j++){
                if(pairs[j][1] < pairs[i][0]){//升序
                    dp[i] = Math.max(dp[j] + 1,dp[i]);
                }
                ret = Math.max(ret,dp[i]);
            }
        }
        return ret;
    }
}
