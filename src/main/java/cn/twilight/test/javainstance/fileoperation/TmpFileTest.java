package cn.twilight.test.javainstance.fileoperation;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 创建临时文件
 */
public class TmpFileTest {

    public static void main(String[] args) {
        createTmpFile();
    }

    public static void createTmpFile(){
        try {
            File tmp  = File.createTempFile("testtempflie",".txt");
            //获取文件的绝对路径
            System.out.println("文件路径:" + tmp.getAbsolutePath());
            tmp.deleteOnExit();

            BufferedWriter out = new BufferedWriter(new FileWriter(tmp));
            out.write("aString");
            System.out.println("临时文件已经被创建");
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
