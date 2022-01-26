package com.twilight.servlet;

import com.twilight.dao.UserDao;
import com.twilight.dao.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    //继承HttpServlet类,重写doGet()和doPost()方法

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String pwd = req.getParameter("pwd");

        UserDao userDao = new UserDaoImpl();
        if (userDao.login(name,pwd)){
            req.setAttribute("xiaoxi","欢迎用户" + name);//向request域中放置信息
            req.getRequestDispatcher("/success.jsp").forward(req,resp);//转发到成功页面
        }else {
            resp.sendRedirect("index.jsp");//重定向到首页
        }
    }
}
