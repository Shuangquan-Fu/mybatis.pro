package com.damu.servlet;

import com.damu.dao.UsersDAO;
import com.damu.entity.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/deluser")
public class UsersDelServlet extends HttpServlet {
    UsersDAO usersDao = new UsersDAO();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String type = req.getParameter("type");
        if("lock".equals(type)){
            //update
            Users user = new Users();
            user.setId(Integer.parseInt(id));
            user.setUserStatus(1);
            usersDao.updateUser(user);


        }else if("del".equals(type)){
            //delete
            usersDao.delUser(Integer.parseInt(id));


        } else if("unlock".equals(type)){
            Users user = new Users();
            user.setId(Integer.parseInt(id));
            user.setUserStatus(0);
            usersDao.updateUser(user);
        }
        resp.sendRedirect("/index");
    }
}
