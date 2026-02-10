package multipleStates;

//https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iv/
public class demo8 {
    class Solution {
        public int maxProfit(int k, int[] prices) {
            int n = prices.length;
            //f[i][j]:第i天结束之后,交易了j次，持股状态
            //g[i][j]:第i天结束之后，交易了j次，不持股状态
            int [][]f = new int [n][k+1];
            int [][]g = new int [n][k+1];
            for(int i = 0;i <= k;i++){
                f[0][i] = -0x3f3f3f3f;
                g[0][i] = -0x3f3f3f3f;
            }
            //初始化
            f[0][0] = -prices[0];
            g[0][0] = 0;

            for(int i = 1;i < n;i++){
                for(int j = 0;j <= k;j++){
                    //持股
                    f[i][j] = Math.max(f[i-1][j],g[i-1][j] - prices[i]);
                    //不持股
                    g[i][j] = g[i-1][j];
                    if(j - 1 >= 0){//说明之前已经至少交易过一次，j-1不会越界
                        g[i][j] = Math.max(g[i-1][j],f[i-1][j-1] + prices[i]);
                    }
                }
            }
            int max_price = 0;
            //找到最后一天手中不持股的最大利润，遍历交易次数，寻找最大值
            for(int i = 0;i <= k;i++){
                max_price = Math.max(max_price,g[n-1][i]);
            }
            return max_price;
        }
    }
}

