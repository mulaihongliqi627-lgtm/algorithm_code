package day9;

import java.util.Scanner;
//时间显示
//https://www.luogu.com.cn/problem/P8748
public class demo2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
//        int []date = new int[3];//时/分/秒
        long a = 0,b = 0,c = 0;
        c = n / 1000;//秒数
        if(c >= 60) {//秒进位到分钟
            b = c / 60;
            c = c % 60;
        }
        if(b >= 60){//分钟进位到小时
            a = b / 60;
            b = b % 60;
            if(a >= 24){
                a %= 24;
            }
        }
        String a_ = String.valueOf(a),b_ = String.valueOf(b),c_ = String.valueOf(c);
        if(a / 10 <= 0){
             a_ = "0" + a_;
        }
        if(b/10 <= 0){
            b_ = "0" + b_;
        }
        if(c/10 <= 0){
            c_ = "0" + c_;
        }
        System.out.println(a_ + ":" + b_ + ":" + c_);

    }
}
