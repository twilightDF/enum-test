package com.twilight.servlet;

import com.twilight.dao.UserDao;
import com.twilight.dao.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        int userId = Integer.parseInt(id);

        UserDao userDao = new UserDaoImpl();
        if (userDao.deleteUser(userId)){
            req.setAttribute("xiaoxi","删除成功");
            req.getRequestDispatcher("/Searchall").forward(req,resp);
        }else {
            resp.sendRedirect("/index.jsp");
        }
    }
}
