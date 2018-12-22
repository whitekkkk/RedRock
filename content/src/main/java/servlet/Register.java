package servlet;

import model.User;
import service.Service;
import work.dao.Dao;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class Register extends HttpServlet {
    private Dao dao;
    private Service service;
    @Override
    public void init()
    {
        dao=Dao.getInstance();
        service=Service.getInstance();
    }
    public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException
    {
        response.setContentType("application/json;charset=utf-8");
        response.setCharacterEncoding("UTF-8");
        String username=request.getParameter("username");
        int password=Integer.parseInt(request.getParameter("password"));
        User user=new User();
        user.setUsername(username);
        user.setPassword(password);
        if(service.isRegister(user))
        {
            response.getWriter().write("注册成功！");
        }
        else{
            response.getWriter().write("注册失败！");
        }
    }
}
