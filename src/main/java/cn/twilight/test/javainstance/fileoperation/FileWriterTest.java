package cn.twilight.test.javainstance.fileoperation;

import java.io.*;

//文件写入
public class FileWriterTest {
    public static void main(String[] args) throws IOException {
        //创建一个缓冲流对象,再将文件字符流放进去
        BufferedWriter out = new BufferedWriter(new FileWriter("D:/runboo.txt"));

        out.write("写入第一条数据");
        out.close();
        System.out.println("文件创建成功!!!");

        //读取文件内容
        BufferedReader reader  = new BufferedReader(new FileReader("D:/runboo.txt"));
        //使用readline方法来读取文件内容
        String str = reader.readLine();
        System.out.println(str);
        System.out.println();

    }
}