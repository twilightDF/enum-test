package com.twilight.servlet;

import com.twilight.dao.UserDao;
import com.twilight.dao.UserDaoImpl;
import com.twilight.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class SearchAllServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDao userDao = new UserDaoImpl();
        List<User> userList = userDao.findAll();
        req.setAttribute("userList",userList);
        req.getRequestDispatcher("/showall.jsp").forward(req,resp);
    }
}
