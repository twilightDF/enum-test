package cn.twilight.test.javainstance.array;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 对数组元素的排序和查找
 * 对数组排序Array.sort()
 * 对数组元素查找 Array.binarySearch();
 * 向数组插入元素 自写
 */
public class TestArrayAPI {
    public static void main(String[] args) {
        Integer[] array = { 2, 5, -2, 6, -3, 8, 0, -7, -9, 4 };

        Integer[] a = {1,2};
        Integer[] b = {3,4};

        //数组排序
        Arrays.sort(array);
        printArray(array);

        //通过binarySearch查找元素2的对应index
        System.out.println();
        System.out.println(Arrays.binarySearch(array, 2));

        //插入元素
        Integer[] newArr = insertElement(array, 2, 5);
        printArray(newArr);

        //获取最大值
        System.out.println(getMax(array));
        //获取最小值
        System.out.println(getMin(array));

        //将两个数组合并为一个数组
        //System.out.println(Arrays.toString((Integer[]) merge(a, b)));

    }


    public static Integer[] insertElement(Integer[] oldArr,int index,int element){
        Integer[] newArr = new Integer[oldArr.length + 1];
        System.arraycopy(oldArr,0,newArr,0,index);
        newArr[index-1] = element;
        System.arraycopy(oldArr,index,newArr,index + 1,oldArr.length - index);
        return newArr;
    }

    public static int getMax(Integer[] arr){
        return (int)Collections.max(Arrays.asList(arr));
    }

    public static int getMin(Integer[] arr){
        return Collections.min(Arrays.asList(arr));
    }

    public static Object[] merge(Integer[] a,Integer[] b){
        List list = new ArrayList(Arrays.asList(a));
        list.addAll(Arrays.asList(b));
        Object[] arr = list.toArray();
        return arr;
    }

    public static void printArray(Integer[] array){
        for(int i = 0;i < array.length;i++){
            if(i != 0)
                System.out.print(",");
            System.out.print(array[i]);
        }
        System.out.println();
    }

}
