package day4;

import java.util.Scanner;

//二分查找,分巧克力问题
public class demo1 {
    static int K = 0;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int k = scan.nextInt();
        K = k;

        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = scan.nextInt(); // 长
            arr[i][1] = scan.nextInt(); // 宽
        }

        // 2. 二分搜索
        int left = 1, right = 100000, ret = 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (check(mid, arr)) {
                ret = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(ret);
        scan.close();
    }

    public static boolean check(int len, int[][] arr) {
        long count = 0;
        for (int i = 0; i < arr.length; i++) {
            count += (long)(arr[i][0] / len) * (arr[i][1] / len);
            if (count >= K) return true; //一旦够了就提前返回
        }
        return count >= K;
    }
}
