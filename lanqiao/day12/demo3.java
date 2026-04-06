package day12;

import java.io.*;

//L1-016 查验身份证
public class demo3 {
    static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws  IOException{
        int []arr = new int []{7,9,10,5,8,4,2,1,6,3,7,9,10,5,8,4,2};
        char[]nums2 = {'1','0','X','9','8','7','6','5','4','3','2'};
        int n = Integer.parseInt(br.readLine());
        String[]s = new String[n];
        for(int i = 0;i < n;i++){
            s[i] = br.readLine();
        }
        boolean allPassed = true;
        for(String str : s){
            boolean isLegal = true;
            int sum = 0;
            //校验前17位
            for(int i = 0;i < str.length()-1;i++){
                if(str.charAt(i) < '0' || str.charAt(i) > '9'){//非法
                    isLegal = false;
                    allPassed = false;
                    break;
                }else{
                    sum += (str.charAt(i) - '0') * arr[i];
                }
            }
            if(isLegal){//校验末尾
                int z = sum % 11;
                if(str.charAt(17) != nums2[z]){//非法
                    allPassed = false;
                    isLegal = false;
                }
            }
            if(!isLegal){
                pw.println(str);
            }

        }
        if(allPassed) pw.print("All passed");
        pw.flush();
    }
}
