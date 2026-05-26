package Knapsack;

import java.util.Scanner;

//牛客DP42完全背包
public class demo5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int n = sc.nextInt();
        int V = sc.nextInt();
        int []v = new int [n];
        int []w = new int [n];
        for(int i = 0;i < n;i++){
            v[i] = sc.nextInt();
            w[i] = sc.nextInt();
        }

        int []dp = new int [V + 1];//dp[i]:背包容量为i时能获得的最大价值
        int []dp2 = new int [V + 1];//dp2[i]:装满容量为i的背包可以获得的最大价值
        for(int i = 1;i <= V;i++){
            dp2[i] = Integer.MIN_VALUE;
        }
        for(int i = 0;i <n;i++){
            for(int j = v[i];j <= V;j++){
                dp[j] = Math.max(dp[j],dp[j-v[i]] + w[i]);
                if(dp2[j - v[i]] >= 0){//前面的状态合法,即恰好存在减去当前添加物品体积的最优解
                    dp2[j] = Math.max(dp2[j],dp2[j - v[i]] + w[i]);
                }
            }
        }

        System.out.println(dp[V]);
        System.out.println(dp2[V] >= 0 ? dp2[V] : 0);


    }
}
