package day11;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class demo5 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    public static void main(String[] args) throws IOException {
        Map<Integer,String> map = new HashMap<>();
        String[]s = {"ling","yi","er","san","si","wu","liu","qi","ba","jiu"};
        String x = br.readLine();

        for(int i = 0;i < x.length();i++){
            if(x.charAt(i) == '-'){
                pw.print("fu" + " ");
            }else{
                String str = s[x.charAt(i) - '0'];
                pw.print(str + (i == x.length() - 1 ? "" : " "));
            }
        }
        pw.flush();
    }
}
