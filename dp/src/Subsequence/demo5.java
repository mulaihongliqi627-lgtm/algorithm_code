package Subsequence;

import java.util.HashMap;
import java.util.Map;
//https://leetcode.cn/problems/longest-arithmetic-subsequence-of-given-difference/description/
public class demo5 {
    public int longestSubsequence(int[] arr, int difference) {
        Map<Integer,Integer> hash = new HashMap<>();
        int ret = 1;
        //使用hash表做动态规划，dp[i]:i位置为结尾的所有子序列中，最长的等差子序列长度
        //以i位置为结尾的值a，需要对前面寻找是否存在构成等差的数b，a-b=d,即b = a-d
        //找到了就让b这个数对应的hash值加一即可，和之前的dp[j]+1同理
        for(int a : arr){
            hash.put(a,hash.getOrDefault(a - difference,0) + 1);
            ret = Math.max(ret,hash.get(a));
        }
        return ret;
    }
}
