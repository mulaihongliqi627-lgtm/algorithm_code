package day13;

import java.io.*;

public class demo2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main1(String[] args) throws  IOException{
        int []arr = new int [4];
        String s = br.readLine();
        for(int i = 0;i < s.length();i++) {
            char ch = s.charAt(i);
            if (ch == 'g' || ch == 'G') arr[0]++;
            else if (ch == 'p' || ch == 'P') arr[1]++;
            else if (ch == 'l' || ch == 'L') arr[2]++;
            else if (ch == 't' || ch == 'T') arr[3]++;
        }
        char[] ch = new char[]{'G','P','L','T'};
        StringBuilder sb = new StringBuilder();
        while (arr[0] > 0 || arr[1] > 0 || arr[2] > 0 || arr[3] > 0){
            for(int j = 0;j < 4;j++){
                if(arr[j] != 0) {
                    sb.append(ch[j]);
                    arr[j]--;
                }
            }
        }
        pw.print(sb);
        pw.flush();
    }

    public static void main(String[] args) {
        String s = "22";
        int x = Integer.parseInt(s);
        System.out.println(s);
    }
}
