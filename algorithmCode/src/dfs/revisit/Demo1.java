package dfs.revisit;

import java.util.ArrayList;
import java.util.List;

//回溯
//https://leetcode.cn/problems/subsets/description/?envType=study-plan-v2&envId=top-100-liked
public class Demo1 {
    private List<List<Integer>> List;
    private List<Integer> path;
    private int len;

    public List<List<Integer>> subsets(int[] nums) {
        len = nums.length;
        path = new ArrayList<>();
        List = new ArrayList<>();
        dfs(nums,0);
        return List;
    }

    public void dfs(int []nums,int start){
        List.add(new ArrayList<>(path));
        for(int i = start;i < len;i++){
            path.add(nums[i]);
            dfs(nums,i+1);
            path.remove(path.size()-1);
        }
    }

    public static void main(String[] args) {
        int []nums = new int []{1,2,3};
        List<List<Integer>> result = new Demo1().subsets(nums);
        System.out.println(result.toString());
    }
}
