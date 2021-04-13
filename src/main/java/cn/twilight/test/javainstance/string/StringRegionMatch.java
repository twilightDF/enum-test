package cn.twilight.test.javainstance.string;

/**
 * 比较两个字符串某指定区域是否相等
 */
public class StringRegionMatch {

    public static void main(String[] args) {
        String str = "nihao world,helloChina";
        String str2 = "goodBey world,NIhao china";

        //表示将str中的第0位,于str2中的第15位开始比较5个字符,若相等,返回true
        boolean match1 = str.regionMatches(0,str2,14,5);
        //第一个参数表示不区分大小写
        boolean match2 = str.regionMatches(true,0,str2,14,5);
        System.out.println(match1);
        System.out.println(match2);
    }

}
