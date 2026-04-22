package Knapsack;

//二维限制背包
//https://leetcode.cn/problems/profitable-schemes/
public class demo6 {
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int len = group.length;
        int [][][]dp = new int [len+1][n+1][minProfit+1];
        int mod = (int)(1e9 + 7);
        for(int i = 0;i <= n;i++){//初始化,没有工作,利润>= 0 限制的方案数都为1
            dp[0][i][0] = 1;
        }
        for(int i = 1;i <= len;i++){
            int a = group[i-1];
            int b = profit[i-1];
            for(int j = 0;j <= n;j++){
                for(int k  = 0;k <= minProfit;k++){
                    dp[i][j][k] = dp[i-1][j][k];//不选,继承先前的状态方案数
                    if(j >= a){//人数够了,可以选
                        dp[i][j][k] = (dp[i][j][k] + dp[i-1][j - a][Math.max(0,k - b)]) % mod;
                    }
                }
            }
        }
        return dp[len][n][minProfit];
    }
}
