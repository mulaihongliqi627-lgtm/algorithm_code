package day13;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
//四平方和
//https://www.luogu.com.cn/problem/P8635#ide
public class demo5 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String[] args) throws  IOException {
        int n = Integer.parseInt(br.readLine());
        Map<Integer,int []> map = new HashMap<>();//c * c + d * d -> c,d
        for(int c = 0;c*c <= n;c++){
            for(int d = c;c * c + d * d <= n;d++){
                if(!map.containsKey(c * c + d * d)){
                    map.put(c * c + d * d,new int[]{c,d});//保证得到的最小的c,d不会被大的覆盖,保证字典序列最小
                }
            }
        }
        for(int a = 0;a*a <= n;a++){
            for(int b = a;a * a +b * b <= n;b++){
                int target = n - (a * a +b * b);
                if(map.containsKey(target)){
                    int []tmp = map.get(target);
                    pw.printf(String.format("%d %d %d %d",a,b,tmp[0],tmp[1]));
                    pw.flush();
                    return;
                }

            }
        }
        pw.flush();
    }
}
