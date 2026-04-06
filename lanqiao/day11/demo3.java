package day11;

import java.io.*;
import java.nio.Buffer;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//java的快速IO模版
public class demo3 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        Map<String,String []> map = new HashMap<>();//试机座位号->准考证号 + 考试座位号
        for(int i = 0;i < n;i++){
            String s[] = br.readLine().split(" ");
            map.put(s[1],new String []{s[0],s[2]});
        }
        int m = Integer.parseInt(br.readLine());
        String[]arr = br.readLine().split(" ");
        for(String s : arr){
            String[] val = map.get(String.valueOf(s));
            pw.println(val[0] + " " + val[1]);
        }
        pw.flush();
    }

    //IO模版
//    public static void main2(String[] args) throws IOException {
//        String line = br.readLine();//读取一行
//        String[]s  = br.readLine().split(" ");//读取一行使用空格分割为String[]
//        int a = Integer.parseInt(br.readLine());//读取一个整数
//        pw.println();   // 换行
//        pw.print("");     // 不换行,但是必须加参数
//        pw.flush();//冲刷缓冲区
//    }
}
