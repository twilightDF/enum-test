package com.twilight.dao;

import com.twilight.entity.User;

import java.util.List;

public interface UserDao {
    public boolean login(String name,String pwd);
    public boolean register(User user);
    public List<User> findAll();

    public boolean deleteUser(int userId);

    public boolean updateUser(User user);
}
