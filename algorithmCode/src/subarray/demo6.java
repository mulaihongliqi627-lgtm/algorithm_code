package subarray;

import java.util.Arrays;

//https://leetcode.cn/problems/longest-turbulent-subarray/
public class demo6 {
    public int maxTurbulenceSize(int[] arr) {
        int n = arr.length;
        int []f = new int [n];//f[i]:以i为结尾的所有子数组中，最后位置呈现上升状态的最长湍流子数组长度
        int []g = new int [n];//下降
        //初始化
        Arrays.fill(f,1);
        Arrays.fill(g,1);
        int  ret = 1;
        for(int i = 1;i < n;i++){
            if(arr[i-1] < arr[i]){
                f[i] = g[i-1] + 1;
            }
            if(arr[i-1] > arr[i]){
                g[i] = f[i-1] + 1;
            }
            ret = Math.max(ret,Math.max(f[i],g[i]));
        }
        return ret;
    }
}
