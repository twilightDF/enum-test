package com.twilight.util;

import java.sql.*;

public class DBConn {
    static String url = "jdbc:mysql://localhost:3306/mydb?useUnicode=true&charsetEncoding=utf8";

    static String username = "root";

    static String password = "123456";

    static Connection conn = null;

    static ResultSet rs = null;

    static PreparedStatement ps = null;

        //抛弃了这个执行SQL的对象，这个对象存在sql注入问题
        //static Statement st = null;

    //创建数据库连接
    public static void init(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url,username,password);
        }catch (Exception e){
            System.out.println("init [SQL驱动程序初始化失败！]");
            e.printStackTrace();
        }
    }

    //数据库写操作
    public static int write(String sql){
        int i = 0;
        try {
            ps = conn.prepareStatement(sql);
            i = ps.executeUpdate();
        }catch (Exception e){
            System.out.println("[数据库写操作异常]:" + sql);
            e.printStackTrace();
        }
        return i;
    }

    //数据库读操作
    public static ResultSet read(String sql){
        try{
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
        }catch (Exception e){
            System.out.println("[数据库读操作异常]:" + sql);
            e.printStackTrace();
        }
        return rs;
    }

    //关闭连接
    public static void closeConn(){
        try{
            conn.close();
        }catch (Exception e){
            System.out.println("close [关闭数据库连接失败]");
            e.printStackTrace();
        }
    }
}
