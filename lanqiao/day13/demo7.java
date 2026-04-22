package day13;

import java.io.*;
import java.util.Scanner;

//同余定理,前缀和
//https://www.luogu.com.cn/problem/P8649#ide
public class demo7 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    public static void main(String[] args) throws  IOException{
        String[]s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]),k = Integer.parseInt(s[1]);
        int []arr = new int[n];
        for(int i = 0; i < n;i++){
            arr[i] = Integer.parseInt(br.readLine().trim());
        }
        int []cnt = new int[k];//记录前缀和的余数出现的次数
        cnt[0] = 1;//前缀和为0 ,出现的次数为1
        long count =0;
        long sum = 0;
        for(int i = 0;i < n;i++){
            sum += arr[i];
            int x = (int) sum % k;//余数
            count += cnt[x];
            cnt[x]++;//对应的余数的计数++;

        }
        pw.print(count);

        pw.flush();
    }
}
