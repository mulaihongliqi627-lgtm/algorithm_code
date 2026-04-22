package Knapsack;

//01背包
//https://leetcode.cn/problems/last-stone-weight-ii/
public class demo4 {
    public int lastStoneWeightII(int[] stones) {
        int n = stones.length;
        int sum = 0;
        for(int x : stones){
            sum += x;
        }
        //把总体分为两部分,一部分数加,一部分减,让每部分尽可能接近sum/2
        int target = sum / 2;
        int []dp = new int [target + 1];
        for(int i = 0;i < n;i++){
            for(int j = target;j >= stones[i];j--){
                dp[j] = Math.max(dp[j],dp[j - stones[i]] + stones[i]);
            }
        }
        return Math.abs(sum - 2*dp[target]);
    }

    public static void main(String[] args) {
        int []stones = {2,7,4,1,8,1};
        int x = new demo4().lastStoneWeightII(stones);
        System.out.println(x);
    }
}
