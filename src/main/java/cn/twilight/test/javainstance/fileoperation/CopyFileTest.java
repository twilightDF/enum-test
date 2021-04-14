package cn.twilight.test.javainstance.fileoperation;

import com.sun.org.apache.bcel.internal.generic.BREAKPOINT;

import java.io.*;

/**
 *
 *操作文件复制
 */
public class CopyFileTest {
    public static void main(String[] args) throws IOException {
        //生成一个源文件
        BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\srcfile"));
        writer.write("this is src file ready be coypied");
        writer.close();

        //生成一个写入流
        InputStream in = new FileInputStream(new File("D:\\srcfile"));
        //生成一个输出流
        OutputStream out = new FileOutputStream(new File("D:\\destfile"));
        //生成一个字节数组
        byte[] bytes = new byte[1024];
        int len;
        if((len = in.read(bytes)) != -1){
            out.write(bytes,0,len);
        }
        in.close();
        out.close();

        //读取文件dest
        BufferedReader reader = new BufferedReader(new FileReader("D:\\destfile"));
        String str;
        if((str = reader.readLine()) != null){
            System.out.println(str);
        }
        reader.close();
    }
}
