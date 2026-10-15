package dfs.revisit;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.cn/problems/generate-parentheses/description/?envType=study-plan-v2&envId=top-100-liked
public class Demo4 {
    private List<String> List;
    private StringBuilder path;
    public List<String> generateParenthesis(int n) {
        List = new ArrayList<>();
        path = new StringBuilder();
        dfs(n,0,0);
        return List;
    }
    public void dfs(int n,int left,int right){
        //终止条件
        if(path.length() == 2 * n){
            List.add(path.toString());
            return;
        }
        //左括号数量小于n时,可以一直添加左括号
        if(left < n){
            path.append("(");
            dfs(n,left + 1,right);
            path.deleteCharAt(path.length() - 1);
        }
        //左括号数量大于右括号时,才能添加右括号
        if(left > right){
            path.append(")");
            dfs(n,left,right+1);
            path.deleteCharAt(path.length() - 1);
        }

    }
}
