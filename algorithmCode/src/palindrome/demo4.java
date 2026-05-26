package palindrome;
//https://leetcode.cn/problems/palindrome-partitioning-ii/
public class demo4 {
    public int minCut(String s) {
        int n = s.length();
        if(n == 1) return 0;
        boolean dp[][] = new boolean[n][n];
        //存储s的所有子串是否能构成回文串与否
        for(int i = n-1;i >= 0;i--){
            for(int j = i;j < n;j++){
                if(s.charAt(i) == s.charAt(j)){
                    dp[i][j] = i + 1 < j ? dp[i+1][j-1] : true;
                }
            }
        }
        int []dp2 = new int [n];
        //预处理
        for(int i = 0;i < n;i++) dp2[i] = 3000;

        //dp2[i]:0 ~ i之间的字符串的最小分割次数
        for(int i = 0;i < n;i++){
            if(dp[0][i]){
                dp2[i] = 0;//整体就是回文串，无需分割
            }else{
                for(int j = i;j >= 0;j--){
                    if(dp[j][i]){
                        dp2[i] = Math.min(dp2[j-1]+1,dp2[i]);
                    }
                }
            }
        }
        return dp2[n-1];
    }

    public static void main(String[] args) {
        String s = "a";
        int x = new demo4().minCut(s);
        System.out.println(x);
    }
}
