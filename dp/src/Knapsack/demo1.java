package Knapsack;

import java.util.Scanner;

//01背包问题
public class demo1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int V = sc.nextInt();
        int[]v = new int [N];//体积
        int[]w = new int [N];//价值
        for(int i = 0;i < N;i++){
            v[i] = sc.nextInt();
            w[i] = sc.nextInt();
        }

        int []dp1 = new int [V + 1];//一维滚动数组
        int []dp2 = new int [V + 1];
        dp2[0] = 0;//装满时0可达
        for(int i = 1;i <= V;i++){
            dp2[i] = -1;
        }
        for(int i = 0;i < N;i++){//i遍历物品,j遍历体积
            for(int j = V;j >= v[i];j--){
                dp1[j] = Math.max(dp1[j],dp1[j - v[i]] + w[i]);

                if(dp2[j - v[i]] >= 0){
                    dp2[j] = Math.max(dp2[j],dp2[j - v[i]] + w[i]);
                }
            }
        }

        System.out.println(dp1[V]);

        // 输出第二行结果
        if (dp2[V] < 0) {
            System.out.println(0); // 无法恰好凑满
        } else {
            System.out.println(dp2[V]);
        }

    }
}
