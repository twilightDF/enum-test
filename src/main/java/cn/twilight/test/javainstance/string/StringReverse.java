package cn.twilight.test.javainstance.string;

/**
 * 字符串翻转
 * reverse()
 * 将字符串转为StringBuffer类型,再调用其reverse()方法,再转回String类型
 */
public class StringReverse {
    public static void main(String[] args) {
        String str = "abcde";
        String strReverse = new StringBuffer(str).reverse().toString();
        System.out.println(strReverse);
    }
}
