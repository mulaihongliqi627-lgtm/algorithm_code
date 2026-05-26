package palindrome;
//https://leetcode.cn/problems/minimum-insertion-steps-to-make-a-string-palindrome/
public class demo6 {
    public int minInsertions(String s) {
        int n = s.length();
        int [][]dp = new int [n][n];
        //dp[i][j],使得s[i,......,j]区间的字符串成为回文串的最小插入次数

        //由于状态转移依赖i+1和j-1的位置，所以需要从下往上，从左往右填dp表
        for(int i = n-1;i >= 0;i--){
            for(int j = i;j < n;j++){
                if(s.charAt(i) == s.charAt(j)){
                    dp[i][j] = i + 1 < j ? dp[i+1][j-1] : 0;//相邻或者重叠时无需插入
                }else {
                    //端点元素不相同时，1：i左边添加一个和s[j] 相同的字符，此时操作数+1，然后使得s[i,....j-1]成为回文串即可
                    //2.j右边添加和s[i]相同的字符，操作数+1，使得s[i+1.....j]成为回文串即可
                    dp[i][j] = Math.min(dp[i][j - 1] + 1, dp[i + 1][j] + 1);
                }
            }
        }
        return dp[0][n-1];
    }

    public static void main(String[] args) {
        String s = "leetcode";
        int x = new demo6().minInsertions(s);
        System.out.println(x);
    }
}
