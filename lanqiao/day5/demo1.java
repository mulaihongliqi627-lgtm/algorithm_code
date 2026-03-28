package day5;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//蓝桥杯,买二赠一,贪心算法,队列
public class demo1 {


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //在此输入您的代码...
        int n = scan.nextInt();
        long []arr = new long [n];
        for(int i= 0;i < n;i++){
            arr[i] = scan.nextLong();
        }
        Arrays.sort(arr);
        scan.close();
        long cost = 0;
        Queue<Long> q = new LinkedList<>();//使用队列存储免费的额度P/2,每次花费额度时消耗队首最大的额度来免费兑// 换
        int i = n - 1;
        while (i >= 0){//贪心,先从贵的买,获得的免费额度free更大,能兑换的商品价值更高
            //尝试拿额度兑换
            if(!q.isEmpty() && q.peek() >= arr[i]){//可以免费换一个
                q.poll();//额度用掉
                i--;//这个零元购,去看下一个
            }else{//换不了
                cost += arr[i];//先买下最贵的
                if(i - 1 >= 0){//还有的话,尝试买了凑一下免费额度
                    cost += arr[i-1];
                    i -= 2;
                    q.add(arr[i-1] / 2);//免费额度算上
                }else{//没货了
                    i--;
                }
            }

        }
        System.out.println(cost);
    }
}
