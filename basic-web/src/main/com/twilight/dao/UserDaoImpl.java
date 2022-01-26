package com.twilight.dao;

import com.twilight.entity.User;
import com.twilight.util.DBConn;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public boolean login(String name, String pwd) {
        boolean flag = false;
        try{
            DBConn.init();
            ResultSet rs = DBConn.read("select * from user where name='" + name + "' and pwd='" + pwd +"'");
            while (rs.next()){
                if (rs.getString("name") == name && rs.getString("pwd") == pwd){
                    flag = true;
                }
            }
            DBConn.closeConn();
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean register(User user) {
        boolean flag = false;
        try{
            DBConn.init();
         int i = DBConn.write("insert into user(name,pwd,sex,home,info) " + "values('" + user.getName() + "','" + user.getPwd() + "','" +
                    user.getSex() + "','" + user.getHome() + "','" + user.getInfo() + "')");

         DBConn.closeConn();
         if(i > 0)flag = true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public List<User> findAll() {
        ArrayList<User> list = new ArrayList<>();
        try{
            DBConn.init();
            ResultSet rs = DBConn.read("select * from user");
            while (rs.next()){
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setPwd(rs.getString("pwd"));
                user.setSex(rs.getString("sex"));
                user.setHome(rs.getString("home"));
                user.setInfo(rs.getString("info"));
                list.add(user);
            }
            DBConn.closeConn();
            return list;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean deleteUser(int userId) {
        boolean flag = false;
        try{
            DBConn.init();
            int i = DBConn.write("delete from user where id=" + userId);
            if (i > 0)flag = true;
            DBConn.closeConn();
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean updateUser(User user) {
        boolean flag = false;
        try{
            DBConn.init();
            int i = DBConn.write("update user set name='" + user.getName() + "','pwd='" + user.getPwd() + "',sex='" +
                                             user.getSex() + "',home='" + user.getHome() + "',info='" + user.getInfo() + "' where id=" + user.getId());
            if (i > 0)flag = true;
            DBConn.closeConn();
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
