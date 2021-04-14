package cn.twilight.test.javainstance.fileoperation;

import java.io.*;

//文件写入
public class FileWriterTest {
    public static void main(String[] args) throws IOException {
        //创建一个缓冲流对象,再将文件字符流放进去
        BufferedWriter out = new BufferedWriter(new FileWriter("D:\\runboo.txt"));

        out.write("写入第一条数据\n");
        out.close();
        System.out.println("文件创建成功!!!");

        //向文件中追加数据
        BufferedWriter out1 = new BufferedWriter(new FileWriter("D:\\runboo.txt",true));
        out1.write("追加第二条数据");
        out1.close();
        //读取文件内容
        BufferedReader reader  = new BufferedReader(new FileReader("D:\\runboo.txt"));
        String str;
        while((str = reader.readLine()) != null){
            //使用readline方法来读取文件内容
            System.out.println(str);
        }
    }
}