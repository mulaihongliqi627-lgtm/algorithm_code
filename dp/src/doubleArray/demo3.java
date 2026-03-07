package doubleArray;
//https://leetcode.cn/problems/distinct-subsequences/
public class demo3 {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        int [][]dp = new int [m+1][n+1];
        //dp[i][j]:s[0,.....,i]内有多少个方式构成t[0,.....j]内的字符
        //初始化,t为空串时
        for(int i = 0;i <= m;i++){
            dp[i][0] = 1;
        }
        for(int i = 1;i <= m;i++){
            for(int j = 1;j <= n;j++){
                //在判断相等之前，防止累加之后又被覆盖
                dp[i][j] = dp[i-1][j];//即使不相同也要引入前驱的状态，状态延续
                if(s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j] += dp[i-1][j-1];
                }

            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        String s = "rabbbit";
        String t = "rabbit";
        int x = new demo3().numDistinct(s,t);
        System.out.println(x);
    }
}
