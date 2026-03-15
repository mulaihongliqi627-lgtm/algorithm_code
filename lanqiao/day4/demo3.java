package day4;

import java.util.Scanner;

public class demo3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //在此输入您的代码...
        int x = scan.nextInt();
        int y = scan.nextInt();
        int total = x * y;
        boolean[] dp = new boolean[total + 1];//dp[i]:i个数的糖果是否可以通过x和y组合出来
        dp[0] = true;//初始化
        int ret = 0;
        for (int i = 1; i <= total; i++) {
            if (i >= x && dp[i - x]) {//可以凑出来i- x : 比如当前i是 11 ,11 - 4 = 7 dp[7] = true;
                dp[i] = true;
            }
            if (i >= y && dp[i - y]) {
                dp[i] = true;
            }
            if (dp[i] == false) {//无法凑出 10 : 6 和 3 都为false
                ret = i;//更新无法组合出的糖数
            }
        }
        System.out.println(ret);
        scan.close();
    }
}
