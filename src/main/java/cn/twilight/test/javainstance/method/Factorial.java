package cn.twilight.test.javainstance.method;

public class Factorial {
    //阶乘算法
    public static void main(String[] args) {
        System.out.println(factorial(4));
    }
    public static Long factorial(Integer num){
        if(num == 1)
            return 1L;
        else
            return factorial(num - 1)*num;
    }
}
