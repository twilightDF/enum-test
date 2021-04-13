package cn.twilight.test.javainstance.string;

/**
 * java字符串比较
 *
 * compareTo();
 *
 */
public class StringCompareEmp {
    public static void main(String[] args) {
        String str = "helloWorld";
        String str2 = "HelloWorld";
        System.out.println(str.compareTo(str2));//返回的是第一个字符的ASCll差值
        System.out.println(str.compareToIgnoreCase(str2));

    }
}
