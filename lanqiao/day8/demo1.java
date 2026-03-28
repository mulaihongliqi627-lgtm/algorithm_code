package day8;

import java.util.*;

//逆序对思想
//https://www.luogu.com.cn/problem/P8613#ide
public class demo1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int []arr = new int [n];
        int[]h = new int [1000005];//身高数组,身高->频次
        for(int i = 0;i < n;i++){
            arr[i] = sc.nextInt();
            h[arr[i]]++;
        }

        long sum = 0;
        for(int i = 0;i < n;i++){
            int k = f(arr[i], h);
            sum += (long)(k*(k + 1) )/ 2;
        }
        System.out.println(sum);
    }

    //检测数组中的前有几个比nums[mid]大,后有多少个比nums[mid]小的数字个数
    public static int f(int height,int []h){
        int k = 0;
        for(int i = 0;i < height;i++){
            k += h[i];
        }
        for(int j = h.length - 1;j > height;j--){
            k += h[j];
        }
        return k;
    }
}
