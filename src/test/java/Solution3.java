import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.junit.Test;

import java.util.ArrayList;
//罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
//
//
//字符          数值
//I             1
//V             5
//X             10
//L             50
//C             100
//D             500
//M             1000
// I II III IV V VI VII VIII IX X
// 例如， 罗马数字 2 写做 II ，即为两个并列的 1;
//              12 写做 XII ，即为 X + II  ;
//              27 写做 XXVII, 即为 XX + V + II ;

// 2891 --> MMDCCCXCI
// 997  --> CMXCVII
// 123  --> CXXIII
//罗马数字转整形
@Setter
@Getter
public class Solution3 {

    @Test
    public void test01(){
        String str = "MMcCCxCi";
        System.out.println(str + "-->" + romanToInt(str.toUpperCase()));
    }

    public int romanToInt(String s) {
        int sum = 0;
        char[] chars = s.toCharArray();
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 0; i < chars.length ; i++) {
            integers.add(Num.getNum(chars[i]));
        }

        //防止数组下标越界
        for(int i = 0;i < integers.size()-1; i ++){
                if (integers.get(i) >= integers.get(i+1)){
                    sum += integers.get(i);
                }else{
                    sum += integers.get(i+1)-integers.get(i);
                    i++;
                }
            }
        sum += integers.get(integers.size() - 1);
        return sum;
    }
}

@AllArgsConstructor
enum  Num{
    I(1),
    V(5),
    X(10),
    L(50),
    C(100),
    D(500),
    M(1000);
    private int num;
    public static int getNum(char c){
        for (Num n:values()) {
            if(n.name().charAt(0) == c){
//            String -> char 也可以这样 : (n.name().toCharArray())[0]
                return n.num;
            }
        }
        throw new UnsupportedOperationException(c + "是什么?");
    }
}