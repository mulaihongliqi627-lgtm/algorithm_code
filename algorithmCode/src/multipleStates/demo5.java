package multipleStates;
//题目链接：https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-cooldown/
public class demo5 {
    public int maxProfit(int[] prices) {
        int m = prices.length;
        // dp[i][0]: 持有股票
        // dp[i][1]: 卖出股票后处于冷冻期
        // dp[i][2]: 不持有股票且不在冷冻期
        int [][]dp = new int [m][3];
        dp[0][0] = -prices[0];
        for(int i = 1;i < m;i++){
            //昨天持有，或者昨天处于冷冻期但是今天买入
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][2]- prices[i]) ;
            //处于冷冻期，说明今天卖出，昨天持股
            dp[i][1] = dp[i - 1][0] + prices[i];
            //不持有股票且不在冷冻期
            dp[i][2] = Math.max(dp[i-1][2],dp[i-1][1]);
        }
        return Math.max(dp[m-1][1],dp[m-1][2]);
    }
}
