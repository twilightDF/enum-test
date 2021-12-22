package cn.twilight.test.javainstance.fileoperation;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Test01 {
    //在电脑D盘下创建一个文件为HelloWorld.txt文件，判断他是文件还是目录，在创建一个目
    //录IOTest,之后将HelloWorld.txt移动到IOTest目录下去；之后遍历IOTest这个目录下的文件


    //要是对文件本身进行操作的话需要操作File对象,不要操作流对象
    //需要对文件中内容进行操作的话就需要操作流对象
    public static void main(String[] args) throws IOException {
        //生成文件
        FileWriter writer = new FileWriter("D://HelloWorld.txt");
        writer.close();

        //读取文件
        File file = new File("D://HelloWorld.txt");
        if (file.isDirectory()) {
            System.out.println(file.getName() + "是一个目录");
        }
        else System.out.println(file.getName() + "是一个文件");

        System.out.println("-----------------------------------");

        File file1 = new File("D://IOTest");
        file1.mkdirs();

        file.renameTo(file1 );
        String[] arr = file1.list();
        for (String s:arr) {
            System.out.println(s);
        }
    }
}
