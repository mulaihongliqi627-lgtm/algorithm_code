package dynamic;

import java.lang.reflect.Array;
import java.util.Arrays;

//跳跃游戏
//https://leetcode.cn/problems/jump-game-ii/description/
public class demo3 {

    public int jump(int[] nums) {
        int n = nums.length;
        int []dp = new int[n];
        //dp[i]:到达i位置所需要的最小跳跃次数
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;//除了0位置，其他位置初始都不可到达
        for(int i = 1;i < n;i++){
            //向前推导起跳位置，找最小的起跳点
            for(int j = 0;j < i;j++){
                if(j + nums[j] >= i){//j位置可以通过一次跳跃到达i位置，或者比i更远的位置
                    //更新次数
                    dp[i] = Math.min(dp[j] + 1,dp[i]);
                }
            }
        }
        return dp[n-1];
    }

    public static void main(String[] args) {
        System.out.println(new demo3().jump(new int[]{2,3,1,1,4}));
    }
}
