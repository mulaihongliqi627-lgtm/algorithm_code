package pointer.slideWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//滑动窗口,找到字符串中所有的字母异位词
//https://leetcode.cn/problems/find-all-anagrams-in-a-string/?envType=study-plan-v2&envId=top-100-liked
public class Demo2 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        int l = 0,n = s.length(),len = p.length();
        int []arr1 = new int [26];
        int []arr2 = new int [26];
        //预处理
        for(int i =0 ;i < len;i++){
            arr2[p.charAt(i) - 'a']++;
        }
        for(int r = l;r < n;r++){
            arr1[s.charAt(r) - 'a']++;
            if(Arrays.equals(arr1,arr2)){//校验
                list.add(l);
            }
            while((r - l + 1) > len){//出窗口
                arr1[s.charAt(l)-'a']--;
                l++;
                if(Arrays.equals(arr1,arr2)){//再校验
                    list.add(l);
                }
            }
        }
        return list;
    }
}
