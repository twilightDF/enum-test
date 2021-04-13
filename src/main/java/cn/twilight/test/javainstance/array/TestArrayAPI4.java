package cn.twilight.test.javainstance.array;

import java.util.Arrays;

public class TestArrayAPI4 {
    public static void main(String[] args) {
        //判断数组是否相等
        Integer[] a = {1,2,3,4,5};
        Integer[] b = {1,2,3,4,5};
        System.out.println(Arrays.equals(a, b));
    }
}
