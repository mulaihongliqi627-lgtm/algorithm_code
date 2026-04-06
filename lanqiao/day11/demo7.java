package day11;

import java.io.*;
import java.util.Arrays;

public class demo7 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw=  new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    public static void main(String[] args) throws IOException {
        String[]s = br.readLine().split(" ");
        int[]arr = new int[s.length];
        int i = 0;
        for(String str : s){
            int x = Integer.valueOf(str);
            arr[i++] = x;
        }
        Arrays.sort(arr);
        for(i = 0;i < arr.length;i++){
            pw.print(arr[i] + (i == arr.length - 1 ? "" : "->"));

        }

        pw.flush();
    }
}
