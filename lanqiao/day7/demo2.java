package day7;

import java.util.Arrays;
import java.util.Scanner;

public class demo2 {
    static int count = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int []nums = new int [n];
        for(int i = 0;i < n;i++){
            nums[i] = sc.nextInt();
        }

        for(int i = 0;i < n;i++){
            //寻找区间内的最大和最小值
            long maxVal = Integer.MIN_VALUE;
            long minVal = Integer.MAX_VALUE;
            for(int j = i;j < n;j++){
                maxVal = Math.max(maxVal,nums[j]);
                minVal = Math.min(minVal,nums[j]);
                if(maxVal - minVal == j - i){//满足连续数列
                    count++;
                }
            }
        }
        System.out.println(count);
    }


}
