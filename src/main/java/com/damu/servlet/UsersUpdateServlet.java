package com.damu.servlet;

import com.damu.dao.UsersDAO;
import com.damu.entity.Users;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet("/updateusers")
public class UsersUpdateServlet extends HttpServlet {
    private Logger log = Logger.getLogger(UsersFindByIdServlet.class);
    private UsersDAO  usersDao = new UsersDAO();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String nickname = req.getParameter("nickname");
        String age =  req.getParameter("age");
        String gender = req.getParameter("gender");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String remark = req.getParameter("remark");

        Users user = new Users(Integer.parseInt(id),nickname,Integer.parseInt(age),gender,phone,email,new Date(),remark);
        System.out.println(user.toString());
        usersDao.updateUser(user);
        resp.sendRedirect("/detail?id="+user.getId());
    }
}
