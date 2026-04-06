package day12;

import java.io.*;
import java.net.spi.InetAddressResolver;
import java.util.Arrays;
import java.util.Collections;

public class demo2 {
    static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException{
        String[]s = br.readLine().split(" ");
        int a = Integer.parseInt(s[0]);
        int b = Integer.parseInt(s[1]);
        int c = Integer.parseInt(s[2]);
        int Max,Mid,Min;
        Integer []arr = new Integer[]{a,b,c};
        Arrays.sort(arr);
//        Arrays.sort(arr, Collections.reverseOrder());//逆序
        for(int i =0 ;i < 3;i++){
            pw.print( i != 2 ? arr[i] + "->" : arr[i]);
        }
        pw.flush();
    }
}
