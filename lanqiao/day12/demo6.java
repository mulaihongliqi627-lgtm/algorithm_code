package day12;

import java.io.*;
import java.net.Inet4Address;

public class demo6 {
    static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        String[]s = br.readLine().split(" ");
        int canDrinkA = Integer.parseInt(s[0]);
        int canDrinkB = Integer.parseInt(s[1]);
        int drinkA = 0,drinkB = 0;//记录喝的杯数
        int n = Integer.parseInt(br.readLine());
        for(int i = 0;i < n;i++){
            String[] cnt = br.readLine().split(" ");
            int a1 = Integer.parseInt(cnt[0]);//甲喊
            int a2 = Integer.parseInt(cnt[1]);//甲划
            int b1 = Integer.parseInt(cnt[2]);
            int b2=  Integer.parseInt(cnt[3]);
            int sumCall = a1 + b1;
            if(a2 == sumCall && b2 != sumCall){//甲输了
                drinkA++;
            }else if(b2 == sumCall && a2 != sumCall){
                drinkB++;
            }else if(b2 == sumCall && a2 == sumCall){//都输了
                drinkA++;
                drinkB++;
            }
            if(drinkA > canDrinkA){//甲倒了
                pw.println("A");
                pw.println(drinkB);
                break;
            }
            if(drinkB > canDrinkB){//乙倒了
                pw.println("B");
                pw.println(drinkA);
                break;
            }
        }
        pw.flush();
    }
}
