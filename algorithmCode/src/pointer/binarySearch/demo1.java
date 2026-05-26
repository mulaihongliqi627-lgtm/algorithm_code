package binarySearch;
//https://leetcode.cn/problems/search-in-rotated-sorted-array/
public class demo1 {
    class Solution {
        public int search(int[] nums, int target) {
            int n = nums.length;
            int left = 0,right = n - 1;
            while(left <= right){
                int mid = (left + right)/2;
                if(nums[mid] == target) return mid;
                if(nums[mid] >= nums[left]){//左边有序
                    if(target <= nums[mid] && target >= nums[left]){//target落在左边
                        right = mid;
                    }else{
                        left = mid + 1;
                    }
                }else{//右边有序
                    if(target <= nums[right] && target > nums[mid]){
                        left = mid;
                    }else{
                        right = mid-1;
                    }
                }
            }
            return -1;
        }
    }
}
