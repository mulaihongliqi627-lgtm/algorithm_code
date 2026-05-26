package greedy;
//柠檬水找零
//https://leetcode.cn/problems/lemonade-change/
public class demo1 {
    public boolean lemonadeChange(int[] bills) {
        int five = 0,ten = 0,twenty = 0;
        for(int x : bills){
            if(x == 5){
                five++;
            }else if(x == 10){
                ten++;
                if(five != 0){
                    five--;
                }else return false;
            }else{//收到张二十的
                if(ten!=0 && five != 0){
                    ten--;
                    five--;
                    twenty++;
                }else if(ten == 0 && five >= 3){
                    five-=3;
                    twenty++;
                }else{
                    return false;
                }
            }
        }
        return true;
    }
}
