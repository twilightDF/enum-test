package com.twilight.servlet;

import com.twilight.dao.UserDao;
import com.twilight.dao.UserDaoImpl;
import com.twilight.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        int userId = Integer.parseInt(id);
        String name = req.getParameter("name");
        String pwd = req.getParameter("pwd");
        String sex = req.getParameter("sex");
        String home = req.getParameter("home");
        String info = req.getParameter("info");
        User user = new User();
        user.setId(userId);
        user.setName(name);
        user.setPwd(pwd);
        user.setSex(sex);
        user.setHome(home);
        user.setInfo(info);

        UserDao userDao = new UserDaoImpl();
        boolean flag = userDao.updateUser(user);

        if (flag){
         req.setAttribute("xiaoxi","更新成功");
         req.getRequestDispatcher("/Searchall.jsp").forward(req,resp);
        }else {
            resp.sendRedirect("/index.jsp");
        }
    }
}
