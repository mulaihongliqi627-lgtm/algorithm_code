package day10;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//https://www.luogu.com.cn/problem/P8637#ide
public class demo2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int []arr = new int[n+1];
        for(int i = 1;i <= n;i++){
            arr[i] = sc.nextInt();
        }
        int count = 0;

        for(int i = 1;i <= n;i++){
            while (arr[i] != i){//索引和对应的值不相同
                int index = arr[i];
                arr[i] = arr[index];
                arr[index] = index;
                count++;
            }
        }
        System.out.println(count);
    }
}
