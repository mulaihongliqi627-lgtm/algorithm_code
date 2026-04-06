package day12;
import java.io.*;


public class demo5 {
    static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String line = br.readLine();
        if (line == null) return;

        String[] s = line.split(":");
        int h = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        // 修改判断逻辑：小时 < 12，或者 12:00 整
        if (h < 12 || (h == 12 && m == 0)) {
            pw.printf("Only %s:%s.  Too early to Dang.\n", s[0], s[1]);
        } else {
            // 计算敲钟次数
            int dangCount = h - 12;
            if (m > 0) dangCount++;

            for (int i = 0; i < dangCount; i++) {
                pw.print("Dang");
            }
            pw.println();
        }
        pw.flush();
    }
}