package day11;

import java.util.Scanner;

//曼哈顿距离
//https://www.luogu.com.cn/problem/P8623
public class demo1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int w = sc.nextInt();
        int m = sc.nextInt();
        int n = sc.nextInt();
        m--;n--;

        //偶数楼号坐标正序,为m%w;奇数楼号坐标反转,为w - 1 - (m%w)
        int r1 = m/w;
        int c1 = (r1 % 2 == 0) ? (m % w) : (w - 1 -(m % w));

        int r2 = n/w;
        int c2 = (r2 % 2 == 0) ? (n % w) : (w - 1 - (n % w));

        int ret = Math.abs(r1 - r2) + Math.abs(c1 - c2);
        System.out.println(ret);

    }
}
