package cn.twilight.test.IOTest;

import java.io.*;

public class BIOTest {
    public static void main(String[] args) throws IOException {
        //BIO之java7之前的读写文件

        //添加文件
        FileWriter file = new FileWriter("test.txt",true);
        file.write("hello world");
        file.close();

        //读取文件
        FileReader reader = new FileReader("test.txt");
        BufferedReader bufferedReader = new BufferedReader(reader);
        StringBuffer buf = new StringBuffer();
        String str;
        while((str = bufferedReader.readLine()) != null){
            buf.append(str + "\n");
        }
        bufferedReader.close();
        reader.close();
        System.out.println(buf.toString());
    }
}
