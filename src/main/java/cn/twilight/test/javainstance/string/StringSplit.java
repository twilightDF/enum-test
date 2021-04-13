package cn.twilight.test.javainstance.string;

import java.util.StringTokenizer;

/**
 * 字符串分割
 * split()
 */
public class StringSplit {
    public static void main(String[] args) {
        String str = "a|b|c|d|e";
        //注意需要转义!!
        String[] tmp = str.split("\\|");
        for (String s: tmp){
            System.out.println(s);
        }

        //调用方法useStringTokenizer
        String str2 = "hello world,hello china,hello chongqing";
        useStringTokenizer(str2);
    }

    //使用StringTokenizer
    public static void useStringTokenizer(String str){
        //默认使用空格分割
        StringTokenizer st = new StringTokenizer(str);
        while(st.hasMoreElements()){
            System.out.println(st.nextElement());
        }
        //使用逗号分割
        StringTokenizer st2 = new StringTokenizer(str, ",");
        while(st2.hasMoreElements()){
            System.out.println(st2.nextElement());
        }
    }

}
