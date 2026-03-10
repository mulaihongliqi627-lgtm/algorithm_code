package day1;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class demo1 {
    //数位求和日期问题
    public static void main(String[] args) {
        int ret = 0;
        int year = 1900, month = 1, day = 1; // 修正起始年份

        // 正确的月份天数数组
        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        while (true) {
            // 1. 数位求和检查
            int x = year / 1000 + (year / 100) % 10 + (year / 10) % 10 + year % 10;
            int y = (month / 10) + (month % 10) + (day / 10) + (day % 10);
            if (x == y) ret++;

            // 2. 终止判断（在检查完最后一天后退出）
            if (year == 9999 && month == 12 && day == 31) break;

            // 3. 处理闰年对2月天数的影响
            if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                days[1] = 29;
            } else {
                days[1] = 28;
            }

            // 4. 日期自增逻辑
            day++;
            if (day > days[month - 1]) {
                day = 1; // 进位后重置为1
                month++;
                if (month > 12) {
                    month = 1; // 进位后重置为1
                    year++;
                }
            }
        }
        System.out.println(ret);
    }

    //ai解法
    public static void main2(String[] args) {
        int count = 0;
        // 1. 预处理月份天数 (2月默认为28)
        int[] daysOfMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        // 2. 第一层：枚举年份
        for (int year = 1900; year <= 9999; year++) {
            int sumY = sumDigits(year);

            // 3. 动态判断闰年，修改2月天数
            if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                daysOfMonth[2] = 29;
            } else {
                daysOfMonth[2] = 28;
            }

            // 4. 第二层：枚举月份
            for (int month = 1; month <= 12; month++) {
                int sumM = sumDigits(month);

                // 5. 第三层：枚举日期
                for (int day = 1; day <= daysOfMonth[month]; day++) {
                    if (sumY == sumM + sumDigits(day)) {
                        count++;
                    }
                }
            }
        }
        System.out.println(count); // 输出结果：70910
    }
    // 独立出求和函数，提高代码复用性与可读性
    private static int sumDigits(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}
