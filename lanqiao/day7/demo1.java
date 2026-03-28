package day7;

//全排列
public class demo1 {
    // 声明全局变量
    static boolean[] used = new boolean[10]; // 标记数字是否被使用过
    static int[] path = new int[10];         // 存储当前正在生成的排列

    /**
     * @param u 当前正在填充第几个位置（从 0 开始）
     */
    static void dfs(int u) {
        // 1. 递归出口：如果填满了所有位置（比如 9 个）
        if (u == 9) {
            // 在这里处理生成的排列（如 check() 或 打印）
            return;
        }

        // 2. 遍历选项：尝试把数字 i 放到当前位置 u
        for (int i = 1; i <= 9; i++) {
            if (!used[i]) { // 如果这个数字还没被占用

                // --- 做选择 ---
                path[u] = i;      // 放入数字
                used[i] = true;   // 打上标记

                // --- 递归下一层 ---
                dfs(u + 1);       // 去填第 u+1 个位置

                // --- 回溯（还原状态） ---
                // 重点：递归回来后，要把刚才占用的数字放回去，供同层其他分支使用
                used[i] = false;
            }
        }
    }
}
