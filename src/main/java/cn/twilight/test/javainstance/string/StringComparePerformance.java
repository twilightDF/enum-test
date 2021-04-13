package cn.twilight.test.javainstance.string;

/**
 * 测试通过两种方式创建字符串的性能
 * 创建字符串有两种方式
 * 1.通过直接赋值给String
 * 2.通过new一个String对象
 *
 * 效率 1 > 2
 */
public class StringComparePerformance {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        for(int i = 0;i < 50000;i++){
            String s1 = "hello";
            String s2 = "hello";
        }
        long endTime = System.currentTimeMillis();
        System.out.println("通过String关键字创建字符串 : "+ (endTime - startTime));

        long startTime1 = System.currentTimeMillis();
        for (int i = 0;i<50000;i++){
            String s3 = new String("hello");
            String s4 = new String("hello");
        }
        long endTime1 = System.currentTimeMillis();
        System.out.println("通过String对象创建字符串" + (endTime1 - startTime1));
    }
}
