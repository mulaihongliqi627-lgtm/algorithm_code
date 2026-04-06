package day13;
import java.io.*;
import java.util.*;

public class demo1 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main1(String[] args) throws IOException {
        String line1 = br.readLine();
        if (line1 == null) return;
        int n = Integer.parseInt(line1);

        Set<String> hasFriends = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split("\\s+");
            int k = Integer.parseInt(s[0]);
            // 关键点：只有 K > 1 的人才算有朋友
            if (k > 1) {
                for (int j = 1; j <= k; j++) {
                    hasFriends.add(s[j]);
                }
            }
        }

        int m = Integer.parseInt(br.readLine());
        String[] queryArr = br.readLine().split("\\s+");

        List<String> result = new ArrayList<>();
        Set<String> alreadyPrinted = new HashSet<>(); // 用于去重且保持顺序

        for (String id : queryArr) {
            // 如果这个人不在“有朋友”集合里，且之前没被记录过
            if (!hasFriends.contains(id) && !alreadyPrinted.contains(id)) {
                result.add(id);
                alreadyPrinted.add(id);
            }
        }

        if (result.isEmpty()) {
            pw.print("No one is handsome");
        } else {
            for (int i = 0; i < result.size(); i++) {
                pw.print(result.get(i) + (i == result.size() - 1 ? "" : " "));
            }
        }
        pw.flush();
    }

    public static void main(String[]args)throws IOException{
        int n = Integer.parseInt(br.readLine());
        int a = 0,b = 0;
        for(int i = 0 ;i < n;i++){
            int x = Integer.parseInt(br.readLine());
            if(x % 2 == 1) a++;
            else b++;
        }
        pw.printf("%d %d",a,b);
        pw.flush();
    }
}