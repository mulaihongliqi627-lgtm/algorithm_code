package Subsequence;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
//https://leetcode.cn/problems/length-of-longest-fibonacci-subsequence/
public class demo6 {
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        // dp[j][i]：以j、i位置为结尾（j < i）的最长斐波那契子序列长度
        int[][] dp = new int[n][n];
        Map<Integer, Integer> hash = new HashMap<>();
        // 存储元素与下标的映射（数组严格递增，无重复元素，可直接存）
        for (int i = 0; i < n; i++) {
            hash.put(arr[i], i);
        }

        // 正确初始化：只初始化dp[j][i]（j < i）为2
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) { // 仅j < i时初始化
                dp[j][i] = 2;
            }
        }

        int maxLen = 2; // 初始最长长度为2（至少两个元素）
        // 遍历所有i（结尾位置），j是i的前一个位置
        for (int i = 2; i < n; i++) {
            for (int j = 1; j < i; j++) {
                int a = arr[i] - arr[j]; // 找前驱元素a = arr[i] - arr[j]
                if (hash.containsKey(a)) {
                    int k = hash.get(a); // a对应的下标k
                    if (k < j) { // 关键：k必须在j前面（k < j < i）
                        // 状态转移：dp[j][i] = dp[k][j] + 1
                        dp[j][i] = dp[k][j] + 1;
                        // 更新最大值
                        maxLen = Math.max(maxLen, dp[j][i]);
                    }
                }
                // 若没有前驱k，dp[j][i]保持初始值2
            }
        }

        // 斐波那契子序列至少需要3个元素，否则返回0
        return maxLen >= 3 ? maxLen : 0;
    }
}
