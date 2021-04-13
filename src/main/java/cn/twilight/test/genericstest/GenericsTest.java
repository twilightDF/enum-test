package cn.twilight.test.genericstest;

/**
 * 泛型 - 广泛的类型,方法中不知道会接收到什么样类型的数据,就没有办法写死,使用泛型,泛指数据类型
 */
public class GenericsTest {
    //写一个泛型方法
    //类型参数声明部分<E>,声明在返回值类型之前
    //可以声明多个类型参数<E,A,B>
    public static <E> void printArray(E[] array){
        for (E element: array){
            System.out.printf("%s ",element);
        }
        System.out.println();;
    }

    //有界的类型参数 - 使得泛型声明时不再接收所有的数据类型,而是有选择性的接收
    //<T extends Comparable<T>>

    public static void main(String[] args) {
        //创建不同类型数组
        Integer[] arrInt = {1, 2, 3, 4, 5};
        Double[] arrDouble = {1.0, 2.0, 3.0, 4.0, 5.0};
        Character[] arrChar = {'a', 'b', 'c', 'd', 'e'};

        printArray(arrInt);
        printArray(arrDouble);
        printArray(arrChar);
    }
}
