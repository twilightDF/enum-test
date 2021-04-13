package cn.twilight.test.javainstance.array;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TestArrayAPI3 {
    public static void main(String[] args) {

        Integer[] a = {1,2,3,4,6};
        Integer[] b = {2,3,4,5,7};

        //使用removeAll来计算两个数组的差集
        System.out.println("使用removeAll来计算两个数组的差集");
        Object[] subtraction = getSubtraction(a,b);
        printArr(subtraction);

        System.out.println("使用retainAll来计算两个数组的交集");

        //使用retainAll来计算两个数组的交集
        Object[] intersection = getIntersection(a, b);
        printArr(intersection);

        System.out.println("利用set的元素唯一性求两个数组的并集");
        //利用set的元素唯一性求两个数组的并集
        printArr(union(a,b));

        System.out.println("在数组中查找指定元素");
        //在数组中查找指定元素
        System.out.println(getElement(a, 1));
    }

    private static Object[] union(Integer[] a, Integer[] b) {
        Set set = new HashSet();
        for (Integer in : a) {
            set.add(in);
        }
        for (Integer in : b) {
            set.add(in);
        }
        return set.toArray();
    }


    private static Integer getElement(Integer[] array, int index) {
        return array[index];
    }

    private static Object[] getIntersection(Integer[] a, Integer[] b) {
        ArrayList arrayListA = new ArrayList(Arrays.asList(a));
        ArrayList anotherA = new ArrayList(Arrays.asList(a));
        ArrayList arrayListB = new ArrayList(Arrays.asList(b));

        arrayListA.retainAll(arrayListB);
        return arrayListA.toArray();
    }

    public static Object[] getSubtraction(Integer[] a,Integer[] b){

        ArrayList arrayListA = new ArrayList(Arrays.asList(a));
        ArrayList anotherA = new ArrayList(Arrays.asList(a));
        ArrayList arrayListB = new ArrayList(Arrays.asList(b));
        arrayListA.removeAll(arrayListB);
        arrayListB.removeAll(anotherA);

        arrayListA.addAll(arrayListB);
        return arrayListA.toArray();
    }

    public static void printArr(Object[] arr){
        for (int i = 0;i < arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}
