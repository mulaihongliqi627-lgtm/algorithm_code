package dynamic;

//爬楼梯
//https://leetcode.cn/problems/climbing-stairs/?envType=problem-list-v2&envId=dynamic-programming
public class demo1 {
    public int climbStairs(int n) {
        int []dp = new int [n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2;i <= n;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
