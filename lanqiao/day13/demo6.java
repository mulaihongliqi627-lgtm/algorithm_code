package day13;

import java.io.*;
//分巧克力,二分
//https://www.luogu.com.cn/problem/P8647#ide
public class demo6 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String[] args) throws IOException{
        String[]s =  br.readLine().split((" "));
        int n = Integer.parseInt(s[0]),k = Integer.parseInt(s[1]);
        int[][]arr = new int[n][2];
        for(int i = 0;i < n;i++){
            String[]s1 = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(s1[0]);
            arr[i][1] = Integer.parseInt(s1[1]);
        }
        int count = 0;//切的巧克力块数
        int left = 1,right = 100000;
        int ret = 1;//最终的长度
        while (left <= right){
            int mid = left + (right - left)/2;
            if(check(mid,k,arr)){
                ret = mid;
                left = mid+1;//尝试找更大的
            }else {//大了,往小了切
                right = mid-1;
            }
        }
        pw.print(ret);


        pw.flush();
    }
    //查看长度为len,能否全部切给k个人
    public  static  boolean check(int len,int k,int[][]arr){
        int count = 0;
        for(int i = 0;i <arr.length;i++){
            count += (arr[i][0] / len) * (arr[i][1] / len);
        }
        return count >= k;
    }
}
