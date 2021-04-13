package cn.twilight.test.javainstance.string;

/**
 * 字符串替换
 * replace()
 * replaceAll()
 * replaceFirst()
 */
public class StringReplace {
    public static void main(String[] args) {
        String str = "helloWorld";

        String str1 = str.replace("l","w");
        System.out.println("replace :" + str1);

        String str2 = str.replaceFirst("l","o");
        System.out.println("replaceFirst :" + str2);

        String str3 = str.replaceAll("l","o");
        System.out.println("replaceAll :" + str3);
    }
}
