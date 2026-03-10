package day1;

import java.util.Scanner;

//快速幂 + 欧拉函数
public class demo2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //在此输入您的代码...
        long a = scan.nextLong();
        long b = scan.nextLong();
        long MOD = 998244353;
        //1.计算Phi
        long phi = getPhi(a);//a^b 和a通过欧拉函数求的的质因数相同
        // 2. 计算 a^(b-1) % MOD

        // 注意：底数 a 也要先对 MOD 取模，防止 a 很大
        long part1 = fastPow(a % MOD, b - 1, MOD);

        // 3. 最终结果 = (part1 * (phi % MOD)) % MOD
        long ans = (part1 * (phi % MOD)) % MOD;

        System.out.println(ans);


        scan.close();
    }
    //欧拉函数获取质因数,模版,背住即可
    public static long getPhi(long n){
        long ret = n;
        for(int i = 2;i * i < n;i++){
            if(n % i == 0){
                ret = ret / i * (i - 1);
                while(n % i == 0) n /= i;
            }
        }
        if(n > 1) ret = ret / n * (n - 1);
        return ret;
    }
    public static long fastPow(long a,long b,long mod){
        long ret = 1;
        a %= mod;
        while(b > 0){//指数一直减半,直到减到0结束
            if(b % 2 == 1){//指数是奇数的情况
                ret = (ret * a) % mod;
            }
            a = (a * a) % mod;//底数平方
            b /= 2;//指数减半
        }
        return ret;
    }
}
