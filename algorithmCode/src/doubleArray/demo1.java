package doubleArray;
//https://leetcode.cn/problems/longest-common-subsequence/
public class demo1 {
    public int longestCommonSubsequence(String s1, String s2) {
        int m = s1.length(),n = s2.length();
        int [][]dp = new int [m+1][n+1];
        //dp[i][j],s1[0...i]和s2[0...j]之间内的最长公共序列长度
        s1 = " " + s1;s2 = " " + s2;//预处理，防止越界
        int max = 0;
        for(int i = 1;i <= m;i++){
            for(int j = 1;j <= n;j++){
                if(s1.charAt(i) == s2.charAt(j)){//元素相同
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
                max = Math.max(max,dp[i][j]);
            }
        }
        return max > 0 ? max : 0;
    }
}
