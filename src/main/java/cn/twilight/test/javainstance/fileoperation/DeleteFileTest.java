package cn.twilight.test.javainstance.fileoperation;

import java.io.File;

/**
 * 测试文件删除
 */
public class DeleteFileTest {
    public static void main(String[] args) {
        try{
            File file = new File("D:\\runboo.txt");
            if(file.delete()){
                System.out.println("文件已删除!");
            }else {
                System.out.println("文件删除失败!");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
