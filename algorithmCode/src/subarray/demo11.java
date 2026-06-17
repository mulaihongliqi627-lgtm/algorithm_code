package subarray;

//https://leetcode.cn/problems/rotate-array/?envType=study-plan-v2&envId=top-100-liked
public class demo11 {

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        reverse(nums,0,n - 1);
        reverse(nums,0,k-1);
        reverse(nums,k,n-1);
    }

    public void reverse(int []nums,int l,int r){
        while(l < r){
            int tmp = nums[l];
            nums[l] = nums[r];
            nums[r] = tmp;
            l++;
            r--;

        }
    }
}
