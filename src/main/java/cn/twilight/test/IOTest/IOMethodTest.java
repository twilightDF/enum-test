package cn.twilight.test.IOTest;

import java.io.*;

public class IOMethodTest {
    public static void main(String[] args) throws IOException {
        //生成一个文件
        //生成文件输出流
        FileWriter file = new FileWriter("test.txt");
        BufferedWriter out = new BufferedWriter(file);
        out.write("hello world");
        out.close();
        file.close();

        //读取文件
        //生成文件输出流
        FileReader reader = new FileReader("test.txt");
        //生成缓冲流
        BufferedReader buf = new BufferedReader(reader);
        while(buf.readLine() != null){
            buf.readLine();
        }

    }
}
