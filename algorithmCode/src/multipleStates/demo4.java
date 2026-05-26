package multipleStates;

//题目链接：https://leetcode.cn/problems/JEj789/
public class demo4 {
    public int minCost(int[][] costs) {
        int m = costs.length;
        int [][]dp = new int [m+1][3];
        for(int i = 1;i <= m;i++){
            dp[i][0] = Math.min(dp[i-1][1],dp[i-1][2]) + costs[i-1][0];
            dp[i][1] = Math.min(dp[i-1][0],dp[i-1][2]) + costs[i-1][1];
            dp[i][2] = Math.min(dp[i-1][1],dp[i-1][0]) + costs[i-1][2];
        }
        return Math.min(dp[m][0],Math.min(dp[m][1],dp[m][2]));
    }

    public static void main(String[] args) {
        int[][]costs = {{17,2,17},{16,16,5},{14,3,19}};
        int ret = new demo4().minCost(costs);
        System.out.println(ret);
    }
}
