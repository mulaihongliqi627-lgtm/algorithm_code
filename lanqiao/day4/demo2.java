package day4;

import java.util.Scanner;

//蓝桥杯暴力模拟,喝饮料问题
public class demo2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //在此输入您的代码...
        int n = scan.nextInt();//最初持有的饮料瓶数
        int drink = 0;//喝的饮料数
        int x = 0;//瓶盖个数
        while(n > 0){
            n--;//喝一瓶,剩余的饮料瓶数减少
            drink++;
            x++;
            if(x % 3 == 0){//可以换一瓶
                n++;
                x = 0;
            }
        }
        System.out.println(drink);
        scan.close();
    }
}
