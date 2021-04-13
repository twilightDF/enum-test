package cn.twilight.test.java8test;

import java.sql.SQLOutput;
import java.util.List;

/**
 * 测试 方法引用
 */
@FunctionalInterface
public interface ImTheOne{
    String handleString(String a,String b);
}

class OneClass{
    public static String staticConcatString(String a,String b){
        return a + b;
    }
    public String concatString(String a,String b){
        return a + b;
    }
}

class test{
    public static void main(String[] args) {
        //调用静态方法
        //类::静态方法
        ImTheOne theOne = OneClass::staticConcatString;
        System.out.println(theOne.handleString("use", "static"));

        //调用非静态方法
        //该类的实例::实例方法
        OneClass oneClass = new OneClass();
        ImTheOne theOne1 = oneClass::concatString;
        System.out.println(theOne1.handleString("use", "instance"));

        //类::实例方法
        //ImTheTwo接口示范

        //构造器引用
        //Class::new


    }
}