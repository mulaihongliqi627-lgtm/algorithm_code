package dfs.revisit;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.cn/problems/combination-sum/?envType=study-plan-v2&envId=top-100-liked
public class Demo3 {
    private List<List<Integer>> List;
    private List<Integer> path;
    private int n,key;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List = new ArrayList<>();
        path = new ArrayList<>();
        n = nums.length;
        key = target;
        dfs(nums,0,0);
        return List;
    }
    public void dfs(int []nums,int sum,int index){
        //终止条件
        if(sum == key){
            List.add(new ArrayList<>(path));
            return;
        }else if(sum > key){
            return;
        }
        for(int i = index;i < n;i++){
            sum += nums[i];
            path.add(nums[i]);
            //传 i:允许当前数字重复选择；
            dfs(nums,sum,i);
            sum -= nums[i];
            path.remove(path.size() - 1);
        }

    }
}
