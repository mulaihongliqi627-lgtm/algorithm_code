package day13;
import java.io.*;
//L1-025 正整数A+B
public class demo3 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String[] args) throws IOException {
        String input = br.readLine();
        if (input == null) return;

        // 1. 找到第一个空格的位置
        int firstSpaceIdx = input.indexOf(" ");

        // 2. 切分 A 和 B
        String strA = input.substring(0, firstSpaceIdx);
        String strB = input.substring(firstSpaceIdx + 1); // 题目保证 B 不为空

        // 3. 验证并处理结果
        boolean okA = isValid(strA);
        boolean okB = isValid(strB);

        String outA = okA ? strA : "?";
        String outB = okB ? strB : "?";
        String res = (okA && okB) ? String.valueOf(Integer.parseInt(strA) + Integer.parseInt(strB)) : "?";

        pw.printf("%s + %s = %s\n", outA, outB, res);
        pw.flush();
    }

    // 检查是否为 [1, 1000] 之间的正整数
    static boolean isValid(String s) {
        if (s == null || s.isEmpty()) return false;

        // 检查是否全为数字
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) return false;
        }

        // 转化为数字并检查范围
        try {
            int val = Integer.parseInt(s);
            return val >= 1 && val <= 1000;
        } catch (NumberFormatException e) {
            // 处理超长字符串导致 Integer 溢出的情况
            return false;
        }
    }
}