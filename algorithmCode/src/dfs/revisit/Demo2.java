package dfs.revisit;

import java.util.ArrayList;
import java.util.List;

//回溯
//https://leetcode.cn/problems/letter-combinations-of-a-phone-number/?envType=study-plan-v2&envId=top-100-liked
public class Demo2 {
    private String[] arr = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    private List<String> List;
    private StringBuilder path;
    public List<String> letterCombinations(String digits) {
        List = new ArrayList<>();
        path = new StringBuilder();
        dfs(digits,0);
        return List;
    }

    public void dfs(String digits,int x){
        //终止条件,path 长度 = digits长度
        if(path.length() == digits.length()){
            List.add(path.toString());
            return;
        }
        int findStr = digits.charAt(x) - '0';
        String str = arr[findStr];
        for(int i = 0;i < str.length();i++){
            //枚举第一个数字对应的字符串中的字符2 -> "abc" -> a[] b[] c[],寻找组合
            path.append(str.charAt(i));
            //去其他字符串中凑出当前数字对应的字符的组合
            dfs(digits,x + 1);
            path.deleteCharAt(path.length()-1);
        }
    }
}
