package Subsequence;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class demo7 {
    public int longestArithSeqLength(int[] nums) {
        int n = nums.length;
        Map<Integer,Integer> hash = new HashMap<>();//元素->下标
        hash.put(nums[0],0);
        int [][]dp = new int [n][n];//dp[i][j]末尾位置 i，j的最大等差序列长度
        //初始化
        for(int i = 0;i < n;i++){
            Arrays.fill(dp[i],2);
        }
        int maxLen = 2;
        //k,i,j     a-b-c   2*b = a + c : -> a = 2 * b - c,固定i，移动j，便于寻找离i最近的k
        for(int i = 1;i < n;i++){
            for(int j = i + 1;j < n;j++){
                int target = 2*nums[i] - nums[j];
                if(hash.containsKey(target)){//能找到元素a
                    int k = hash.get(target);//获取a的下标
                    dp[i][j] = dp[k][i] + 1;//更新，对应的等差数组长度增加
                }
                maxLen = Math.max(maxLen,dp[i][j]);
            }
            //优化：在内层循环找 hash.get(target) 时，哈希表里只存了下标小于 i的元素。使得可以获取到最新的k
            hash.put(nums[i],i);//覆盖旧值
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int []nums = {83,20,17,43,52,78,68,45};
        int x = new demo7().longestArithSeqLength(nums);
        System.out.println(x);
    }
}
