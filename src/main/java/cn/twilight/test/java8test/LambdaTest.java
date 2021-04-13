package cn.twilight.test.java8test;

/**
 * 测试lambda表达式用法
 *
 * 1.定义一个接口,该接口只有一个方法(函数式接口)
 * 2.在需要实现这个接口的地方声明该接口,并通过(a,b)方式传参,通过 ->{a + b}的方式定义方法体
 *  2.1传入的参数只有一个时小括号可以省略
 *  2.2方法定义只有一个语句,则不需要大括号
 *  2.3如果方法体中只有一个表达式返回值,编译器会自动返回
 */
public class LambdaTest {
    //外层局部变量
    public static String salutation = "hello";

    public static void main(String[] args) {
        MathOperation add = (a,b) -> a+b;
        MathOperation sub = (a,b) -> a-b;
        MathOperation mul = (a,b) -> a*b;

        System.out.println(add.operation(1,2));

        System.out.println(doOperation(2, 3, sub));

        GreetingService sayHello = message -> System.out.println("hello" + message);
        //GreetingService sayHello2 = message -> message + "hello";
        sayHello.greeting("world");

        GreetingService sayHello2 = message -> System.out.println(salutation + message);
        sayHello2.greeting("world!!!!");
        }

    private static int doOperation(int a,int b,MathOperation op){
        return op.operation(a,b);
    }
}
interface MathOperation{
    int operation(int a,int b);
}

interface GreetingService{
    void greeting(String message);
}
