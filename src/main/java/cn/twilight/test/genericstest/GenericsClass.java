package cn.twilight.test.genericstest;

//表示该类接收所有类型数据
public class GenericsClass<T> {
    private T t;


    public void add(T t){
        this.t = t;
    }

    //泛型方法
    public T get(){
        return t;
    }

    public static void main(String[] args) {
        GenericsClass<String> stringType = new GenericsClass<String>();
        GenericsClass<Integer> integerType = new GenericsClass<Integer>();

        stringType.add(new String("你好"));
        integerType.add(new Integer(2));

        System.out.println(stringType.get());
        System.out.println(integerType.get());

    }

}
