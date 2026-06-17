package subarray;

//https://leetcode.cn/problems/first-missing-positive/?envType=study-plan-v2&envId=top-100-liked
public class demo10 {
    //原地哈希
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for(int i = 0;i < n;i++){
            //值不越界, 原本该放的位置和自身位置不符时,进行交换
            while(nums[i] >= 1 && nums[i] <= n && nums[nums[i] - 1] != nums[i]){
                swap(nums,nums[i] - 1, i);
            }
        }
        //此时数组中i位置存放值为i+1的数字,进行遍历
        for(int i = 0;i < n;i++){
            //值和位置不同,返回
            if(nums[i] != i+1){
                return i + 1;
            }
        }
        //都符合,数组连续有序, 返回数组长度+1
        return n+1;
    }
    public void swap(int []arr,int l,int r){
        int tmp = arr[l];
        arr[l] = arr[r];
        arr[r] = tmp;
    }
}
