package cn.twilight.test.javainstance.string;

import java.sql.SQLOutput;

/**
 * 查找字符串最后一次出现的位置
 * lastIndexOf()
 */
public class SearchLastString {

    public static void main(String[] args) {
        String str = "你好HelloWorld,世界你好!";
        int lastIndex = str.lastIndexOf("你好");
        System.out.println(lastIndex);
        //如果没有找到对应的字符串,lastIndexOf返回 -1
        System.out.println(str.lastIndexOf("狗屎!"));


        System.out.println(str.indexOf("你好"));
    }


}
