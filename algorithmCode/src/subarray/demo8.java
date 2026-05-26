package subarray;
//https://leetcode.cn/problems/unique-substrings-in-wraparound-string/description/
public class demo8 {
    public int findSubstringInWraproundString(String s) {
        int n = s.length();
        int []dp = new int [n];
        //dp[i]：以i结尾的字符串有多少个子串在base中出现过
        int []hash = new int [26];
        for(int i = 0;i < n;i++) dp[i] = 1;
        for(int i = 1;i < n;i++){
            if(s.charAt(i) == s.charAt(i-1) + 1 || s.charAt(i-1) == 'z' && s.charAt(i) == 'a'){
                dp[i] += dp[i-1];
            }
        }
        //去重
        for(int i = 0;i < n;i++){
            hash[s.charAt(i) - 'a'] = Math.max(hash[s.charAt(i) - 'a'],dp[i]);
        }
        int ret = 0;
        for(int x : hash){
            ret += x;
        }
        return ret;
    }

    public static void main(String[] args) {
        String s = "abcd";
        int x = new demo8().findSubstringInWraproundString(s);
        System.out.println(x);
    }
}
