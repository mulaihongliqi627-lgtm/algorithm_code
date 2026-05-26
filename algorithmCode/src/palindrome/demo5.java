package palindrome;
//https://leetcode.cn/problems/longest-palindromic-subsequence/
public class demo5 {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        if(n == 1) return 1;
        int [][]dp = new int[n][n];//dp[i][j]:s[i......j]区间内的最长回文子序列长度
        int maxLen = 0;
        for(int i = n-1;i >= 0;i--){
            dp[i][i] = 1;//初始化
            for(int j = i+1;j < n;j++){
                if(s.charAt(i) == s.charAt(j)){//端点元素相等
                    dp[i][j] = Math.max(dp[i][j],dp[i+1][j-1] + 2);
                }else{//两端点元素不同
                    //去除一个不同的端点在剩余子串找最大值，比如abbd- > bbd || abb
                    if(i + 1 < n){
                        dp[i][j] = Math.max(dp[i][j-1],dp[i+1][j]);
                    }

                }
                maxLen = Math.max(maxLen,dp[i][j]);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String s = "aaa";
        int x = new demo5().longestPalindromeSubseq(s);
        System.out.println(x);
    }
}
