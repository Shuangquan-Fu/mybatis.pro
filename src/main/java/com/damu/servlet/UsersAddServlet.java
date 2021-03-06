package com.damu.servlet;

import com.damu.dao.UsersDAO;
import com.damu.entity.Users;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet("/addusers")
public class UsersAddServlet extends HttpServlet {
    private Logger log = Logger.getLogger(UsersFindByIdServlet.class);
    private UsersDAO usersDAO = new UsersDAO();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取要添加的用户数据
        String username = req.getParameter("username");
        String userpass = req.getParameter("userpass");
        String nickname = req.getParameter("nickname");
        String age =  req.getParameter("age");
        String gender = req.getParameter("gender");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");

        //根据获得的数据 来创建 一个用户对象
        Users user = new Users(username,userpass,nickname,Integer.parseInt(age),gender,phone,email,new Date(),new Date(),new Date(),0);

        //将创建的用户对象 添加到数据库中
        Users users = usersDAO.addUser(user);
        //查询刚新增的用户数据
        System.out.println(users.toString());

        resp.sendRedirect("/detail?id="+users.getId());
    }
}
