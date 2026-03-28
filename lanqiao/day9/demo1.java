package day9;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class demo1 {
    public static void main(String[] args) {
        List<Integer>list = new LinkedList<>();
        for(int i = 1;i <= 1000000;i++){
            if(isPrime(i)) list.add(i);
        }
        System.out.println(list);
    }
    public static boolean isPrime(int num){
        if(num < 2) return false;
        for(int i = 2;i <= Math.sqrt(num);i++){
            if(num % i == 0) return false;
        }
        return true;
    }
}
