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

@WebServlet("/detail")
public class UsersFindByIdServlet extends HttpServlet {
//    如何创建日志进行 debug 或者进行infor 展示 或者可以通过
//    logj4.properties 进行修改 debug 还是 info
    //通过实例后，可以进行实例化进行  通过log.info()输出内容
    private  Logger log = Logger.getLogger(UsersFindByIdServlet.class);
    private UsersDAO usersDAO = new UsersDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("正在servlet中");

        String id = req.getParameter("id");
        log.info("获取到的数据"+ id);
        Users user = usersDAO.findById(Integer.parseInt(id));
        System.out.println(user);
        req.setAttribute("user",user);
        req.getRequestDispatcher("detail.jsp").forward(req,resp);
    }
}
