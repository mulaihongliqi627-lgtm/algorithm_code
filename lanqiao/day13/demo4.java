package day13;

import java.io.*;

//L1-108 零头就抹了吧
public class demo4 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String[] args) throws  IOException{
        int i = 0;
        int n = Integer.parseInt(br.readLine());
        int ret = 0;
        while (ret < n){
            ret = (int) Math.pow(2,i);
            i++;
        }
        if(ret == n){
            pw.print(ret);
        }else{
            pw.print(ret/2);
        }

        pw.flush();

    }

}
