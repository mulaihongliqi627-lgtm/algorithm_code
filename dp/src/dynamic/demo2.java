package dynamic;

public class demo2 {

    //跳跃游戏
    //https://leetcode.cn/problems/jump-game/?envType=problem-list-v2&envId=dynamic-programming
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int []dp = new int [n+1];
        int k = 0;//记录能从起点跳跃到的最远距离
        for(int i = 0;i < n;i++){
            //i > k说明永远无法跳跃到末尾，maxReach 是单调不减的后续i只会大于k，不可达
            if(i > k) return false;
            k = Math.max(k,i + nums[i]);
        }
        return true;
    }
}
