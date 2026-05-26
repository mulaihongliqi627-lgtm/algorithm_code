package subarray;

import java.util.*;
//https://leetcode.cn/problems/word-break/description/
public class demo7 {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> hash = new HashSet<>();
        for(String s_ : wordDict){
            hash.add(s_);
        }
        int n = s.length();
        boolean[]dp = new boolean[n+1];
        dp[0] = true;
        //f[i]:0~i区间内的字符是否可以由字典中的单词拼接而成
//        s =s + " ";//防止字符串截取时下标溢出
        for(int i = 1;i <= n;i++){
            for(int j = i;j >= 1;j--){
                if(dp[j-1] && hash.contains(s.substring(j-1,i))){//[0,j-1]区间内符合，并且[j,i+1]内的单词可查到
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        String s = "catsandog";
        String[]Str = {"cats", "dog", "sand", "and", "cat"};
        List<String> List = new LinkedList<>();
        for(String x : Str){
            List.add(x);
        }
        System.out.println(new demo7().wordBreak(s,List));

    }
}
