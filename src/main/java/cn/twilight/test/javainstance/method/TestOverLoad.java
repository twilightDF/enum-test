package cn.twilight.test.javainstance.method;

/**
 * 方法重载
 * 方法名相同,
 */
public class TestOverLoad {
    TestOverLoad(String s){
        //有参构造
        System.out.println("hello" + s);
    }
    TestOverLoad(){
        System.out.println("hello");
        //无参构造
    }
    public static void main(String[] args) {
        //测试方法重载
        TestOverLoad t1 = new TestOverLoad("World");

        TestOverLoad t2 = new TestOverLoad();
    }
}
