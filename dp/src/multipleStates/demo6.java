package multipleStates;
//https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
public class demo6 {
    public int maxProfit(int[] prices, int fee) {
        int m = prices.length;
        //dp[i][0]:第i天结束后，持股
        //dp[i][1]:第i天结束后，不持股
        int [][]dp = new int [m][2];
        dp[0][0] = -prices[0];
        for(int i = 1;i < m;i++){
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1] - prices[i]);//昨天持股，今天持股；昨天不持股，今天买入
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0] + prices[i] - fee );//昨天不持股，今天也不持股；昨天持股，今天卖出
        }
        return dp[m-1][1];
    }
}
