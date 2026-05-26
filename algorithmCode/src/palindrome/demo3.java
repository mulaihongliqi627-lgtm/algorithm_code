package palindrome;

public class demo3 {
    public boolean checkPartitioning(String s) {
        int n = s.length();
        boolean[][]dp = new boolean [n][n];//dp[i][j]:s[i,.....,j]之间的字符串是否是回文串
        //保存所有回文串信息
        for(int i = n-1;i >= 0;i--){
            for(int j = i;j < n;j++){
                if(s.charAt(i) == s.charAt(j)){
                    dp[i][j] = i + 1 < j ? dp[i+1][j-1] : true;
                }
            }
        }
        //s1 ,s2, s3,进行遍历,两个分割界移动尝试寻找合法情况
        for(int i = 1;i < n;i++){
            for(int j = i + 1;j < n;j++){
                if(dp[0][i-1] && dp[i][j-1] && dp[j][n-1]){
                    return true;
                }
            }
        }
        return false;
    }
}
