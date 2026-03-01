package Subsequence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//https://leetcode.cn/problems/arithmetic-slices-ii-subsequence/
public class demo8 {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        if(n <= 2) return 0;
        int[][]dp = new int [n][n];
        Map<Long, List<Integer>> hash = new HashMap<>();//List存储出现过的下标，用于统计个数

        //预处理nums中的元素以及出现的下标
        for(int i = 0;i < n;i++){
            long tmp = (long)nums[i];
            if(!hash.containsKey(tmp)){
                hash.put((long)nums[i],new ArrayList<>());
            }
            hash.get(tmp).add(i);//添加元素+出现过的下标
        }
        int ret = 0;
        for(int j = 1;j < n;j++){
            for(int i = 0;i < j;i++) {
                long target = (long) (2 * nums[i] - nums[j]);
                if (hash.containsKey(target)) {
                    for (int k : hash.get(target)) {
                        if (k < i) {
                            dp[i][j] += dp[k][i] + 1;
                        } else break;
                    }
                }
                ret += dp[i][j];
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int []nums = {2,4,6,8,10};
        int x = new demo8().numberOfArithmeticSlices(nums);
        System.out.println(x);
    }
}
