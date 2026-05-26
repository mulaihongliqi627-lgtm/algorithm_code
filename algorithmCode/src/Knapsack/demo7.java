package Knapsack;
//二维限制背包
//https://leetcode.cn/problems/ones-and-zeroes/description/
public class demo7 {
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        int [][][]dp = new int [len+1][m+1][n+1];
        for(int i = 1;i <= len;i++){
            int a = 0,b = 0;
            String str = strs[i-1];
            for(int _i = 0;_i < str.length();_i++){
                if(str.charAt(_i) == '0'){
                    a++;
                }else{
                    b++;
                }
            }
            for(int j = 0;j <= m;j++){
                for(int k = 0;k <= n;k++){
                    dp[i][j][k] = dp[i-1][j][k];
                    if(j >= a && k >= b){
                        dp[i][j][k] = Math.max(dp[i-1][j][k],dp[i-1][j - a][k - b] + 1);
                    }

                }
            }
        }
        return dp[len][m][n];
    }
}
