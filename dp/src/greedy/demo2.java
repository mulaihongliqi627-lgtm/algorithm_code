package greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

//贪心算法
//https://leetcode.cn/problems/minimum-operations-to-halve-array-sum/description/
public class demo2 {
    public int halveArray(int[] nums) {

        //建大根堆
        PriorityQueue<Double> heap = new PriorityQueue<>(Collections.reverseOrder());
        double sum = 0;
        for (double x : nums){
            heap.add(x);
            sum += x;
        }
        sum /= 2.0;
        int count = 0;
        while (sum > 0){
            double num = heap.poll();//获取最大元素
            sum -= num / 2.0;
            count++;
            heap.add(num / 2.0);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {5,19,8,1};
        System.out.println(new demo2().halveArray(nums));
    }
}
