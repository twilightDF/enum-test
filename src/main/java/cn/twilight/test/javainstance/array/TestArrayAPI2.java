package cn.twilight.test.javainstance.array;

import java.util.Arrays;

public class TestArrayAPI2 {
    static Integer[] array =  new Integer[6];

    public static void main(String[] args) {

        //数组填充 Arrays.fill(arrayname,value)
        Arrays.fill(array,10);
        printArr(array);
        System.out.println("##########");
        //数组填充 Arrays.fill(arrayname ,starting index ,ending index ,value)
        Arrays.fill(array,3,6,50);
        printArr(array);

        //数组扩容
        //System.arraycopy();

        //查找数组中重复的元素
        findRepeatInArray(array);

        //删除数组元素
        Integer[] newArr = deleteElement(array,4);
        printArr(newArr);
    }

    private static Integer[] deleteElement(Integer[] array, int index) {

        Integer[] newArr = new Integer[array.length - 1];
        //判断元素是否越界
        if(index < 0 || index > array.length){
            throw new RuntimeException("数组下标越界");
        }
        for(int i = 0;i < newArr.length;i++){
            if (i < index){
                newArr[i] = array[i];
            }else {
                newArr[i] = array[i + 1];
            }
        }
        return newArr;
    }


    public static void printArr(Integer[] arr){
        for(int i = 0;i < arr.length;i++){
            System.out.println(arr[i]);
        }
    }

    private static void findRepeatInArray(Integer[] array) {
        int flag = 0;
        for(int i = 0;i < array.length;i++){
            for (int j = i+1;j < array.length;j++){
                if(array[i] == array [j])
                    flag++;
                if (flag == 1){
                    System.out.println("重复元素:" + array[i]);
                    flag = 0;
                }
            }
        }
    }

}
