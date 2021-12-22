package cn.twilight.test.java8test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class TestPredicate {
    public static void main(String[] args) {
        //最基本的创建Predicate对象
        Predicate<String> predicate = new Predicate() {
            @Override
            public boolean test(Object o) {
                return ((String) o).length() > 4?true:false;
            }
        };

        //函数式接口方法直接创建一个predicate对象
        Predicate<Integer> predicate1 = x -> x>3;
        //test方法,触发断言的判断逻辑,返回boolean值
        System.out.println(predicate1.test(5));

        List<String> names = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp","Hell","opt");

        System.out.println("#####测试test#####");
        names.stream()
                .filter(predicate)
                //.filter(x -> x.length() > 4)//也可以这样写
                .forEach(x -> System.out.println(x));

        //and,同时满足and
        System.out.println("######测试and######");
        Predicate<String> predicate2 = x -> x.length() > 4;
        Predicate<String> predicate3 = x -> x.length() < 6;
        names.stream()
                .filter(predicate2.and(predicate3))
                .forEach(x -> System.out.println(x));
        //or,至少满足一个
        //TODO
        //negate,非
        //TODO
        //isEqual,先判断对象是否为NULL,不为Null的话再使用equals()方法进行比较
        //TODO
    }
}
