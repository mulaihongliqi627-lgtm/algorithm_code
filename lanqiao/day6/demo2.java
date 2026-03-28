package day6;

import java.util.PriorityQueue;
import java.util.Scanner;

public class demo2 {
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        StringBuilder s1 = new StringBuilder(a);

        int n1 = a.length(),n2 = b.length();
        if(n1 != n2) System.out.print(0);
        int i = 0,n = n1;
        int cnt = 0;
        while(i < n){
            if(s1.charAt(i) != b.charAt(i)){//开始反转两枚硬币
                s1.setCharAt(i,s1.charAt(i) == 'o'?'*':'o');
                if(i + 1 < n){
                    s1.setCharAt(i+1,s1.charAt(i) == 'o'?'*':'o');
                }
                cnt++;
            }
            i++;
        }
        System.out.println(cnt);
    }
}
