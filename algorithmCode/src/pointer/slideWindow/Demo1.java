package pointer.slideWindow;
//滑动窗口
//https://leetcode.cn/problems/longest-substring-without-repeating-characters/?envType=study-plan-v2&envId=top-100-liked
public class Demo1 {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLen = 0;
        int []arr = new int [128];
        int l = 0;
        for(int r = l;r < n;r++){
            char ch = s.charAt(r);
            arr[ch]++;
            while(arr[ch] > 1){//出现重复
                arr[s.charAt(l)]--;//出窗口
                l++;
            }
            maxLen = Math.max(maxLen,r - l + 1);
        }
        return maxLen;
    }
}
