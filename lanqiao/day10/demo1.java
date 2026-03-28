package day10;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

//修建灌木
//https://www.luogu.com.cn/problem/P8781#ide


public class demo1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();

        int[] arr = new int[n];      // 当前灌木高度
        int[] maxH = new int[n];     // 记录历史最高高度

        int i = 0;                   // 当前 Alice 所在的位置
        int step = 1;                // 移动方向：1 为向右，-1 为向左

        // 模拟次数：一个来回是 2*(n-1) 天，我们模拟两个来回 (4n) 确保万无一失
        int totalDays = 4 * n;
        int day = 0;

        while (day < totalDays) {
            // 1. 早上到傍晚：所有树长高 1cm
            grow(arr);

            // 2. 傍晚修剪前，记录当前所有树的高度（因为现在是它们今天最高的时候）
            for (int j = 0; j < n; j++) {
                maxH[j] = Math.max(maxH[j], arr[j]);
            }

            // 3. 傍晚：砍掉当前位置 i 的树
            arr[i] = 0;

            // 4. 准备移动：判断是否撞到边界需要掉头
            // 如果在最右边且还要往右，或者在最左边且还要往左，就掉头
            if (i == n - 1 && step == 1) {
                step = -1;
            } else if (i == 0 && step == -1) {
                step = 1;
            }

            i += step;
            day++;
        }

        // 输出结果
        for (int h : maxH) {
            System.out.println(h);
        }
    }

    public static void grow(int[] arr) {
        for (int j = 0; j < arr.length; j++) {
            arr[j]++;
        }
    }
}
