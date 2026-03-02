package palindrome;
//https://leetcode.cn/problems/palindromic-substrings/submissions/702016433/
public class demo2 {
    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][]dp = new boolean[n][n];//dp[i][j]:s[i,....j]的字符串是否是回文串
        int ret = 0;
        for(int i = n-1;i >= 0;i--){//从右下往上填表
            for(int j = i;j < n;j++){
                if(s.charAt(i) != s.charAt(j)){//不构成回文串
                    dp[i][j] = false;
                    continue;
                }
                dp[i][j] = i + 1 < j ? dp[i+1][j-1] : true;//i，j元素相等时：重合或者内层也是回文串时，dp[i][j]符合
                if(dp[i][j] == true ){
                    ret++;//计数
                }
            }
        }
        return ret;
    }
}
