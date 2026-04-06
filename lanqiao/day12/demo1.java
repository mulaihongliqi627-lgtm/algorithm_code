package day12;

import java.io.*;

//L1-009 N个数求和
public class demo1 {
    static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        String []s = br.readLine().split(" ");
        int finalA = 0,finalB = 1;//结果的分子和分母
        for(int i =0 ;i < n;i++){
            String[]str = s[i].split("/");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);
            long retc = (long) finalA * b + (long) finalB * a;
            long retC = (long)finalB * b;
            long num = gcb((int) retc,(int) retC);//最大公因子
            //约分
            finalA = (int) (retc / num);
            finalB = (int) (retC / num);
        }
        if(finalA % finalB == 0){//可以表示为一个整数
            pw.print(finalA/finalB);
        }else if(Math.abs(finalA) < Math.abs(finalB)){//不大于1
            pw.print(finalA + "/" + finalB);
        }else{//可以表示为带分数的形式
            int Num = finalA / finalB;
            int nextA = finalA % finalB;
            int nextB = finalB;
            pw.print(Num + " " + nextA + "/" +nextB);
        }
        pw.flush();

    }
    //辗转相除法求最大公因子
    public static long gcb(int a,int b){
        return b == 0 ? a : gcb(b,a%b);
    }
}
