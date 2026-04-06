package day11;

import java.io.*;
import java.util.List;
//连续因子
//https://pintia.cn/problem-sets/994805046380707840/exam/problems/type/7?problemSetProblemId=994805138600869888
public class demo4 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    public static void main(String[] args) throws IOException {
        long n = Long.parseLong(br.readLine());
        int maxLen = 1;
        int start = 0;
        long limit = (long) Math.sqrt(n);
        for(int i = 2;i <= limit;i++){
            int curLen = 0;
            long x = 1;
            for(int j = i;;j++){//以i为起始开始累乘
                x *= j;
                if(n % x == 0){
                    curLen = j - i + 1;
                    if(curLen > maxLen){
                        maxLen = curLen;
                        start = i;//最长起始因子更新
                    }
                }else{
                    break;
                }
            }
        }
        if(maxLen == 1){
            pw.println(1);
            pw.println(n);
        }else {
            pw.println(maxLen);
            for(int i = start;i <= start + maxLen - 1;i++){
                pw.print(i + (i == start + maxLen - 1 ? "" : "*"));
            }
        }
        pw.flush();
    }
}
