package cn.twilight.test.javainstance.string;

/**
 * 删除字符串中的一个字符
 * 写一个方法可以删除字符串任意位置的一个字符
 * substring();截取字符串
 */
public class RemoveChat {
    public static void main(String[] args) {
        String str = "HelloWorld";
        System.out.println(Remove(str, 4));

    }

    public static String Remove(String str,int pos){
        String newString = str.substring(0,pos) + str.substring(pos+1,str.length());
        return newString;
    }
}
