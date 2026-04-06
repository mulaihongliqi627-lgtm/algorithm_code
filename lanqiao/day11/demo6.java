package day11;

import java.io.*;
import java.net.Inet4Address;

public class demo6 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    public static void main(String[] args) throws IOException{
        String []s = br.readLine().split(" ");
        int a = Integer.valueOf(s[0]);
        int b = Integer.valueOf(s[1]);
        int cnt = 0;
        int sum = 0;
        for(int i = a;i <= b;i++){
            pw.printf("%5d",i);
            sum += i;
            cnt++;
            if(cnt == 5){
                cnt = 0;
                pw.println();
            }
        }
        pw.println();
        pw.println("Sum = " + sum);
        pw.flush();
    }
}
