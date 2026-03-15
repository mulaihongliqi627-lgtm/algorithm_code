package day2;

import java.util.Scanner;

//蓝桥杯真题,贪心算法,填充问题
public class demo2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //在此输入您的代码...
        String s = scan.next();
        int n = s.length();
        char[]arr = s.toCharArray();
        int count = 0;
        for(int i = 1;i < n;i++){
            if(arr[i] == arr[i-1] || (arr[i] != arr[i-1] && (arr[i] == '?' || arr[i-1] == '?'))){//可以凑成一对
                count++;
                i++;//和for循环中的i++,后移两步,寻找下一对
            }
            //不能凑成一对时i++,后移一步,向下一个位置判断是否可以凑成00 或 11
        }
        System.out.println(count);
        scan.close();
    }
}
