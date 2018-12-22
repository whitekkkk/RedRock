package servlet;

import model.Message;
import model.User;
import net.sf.json.JSONArray;
import service.Service;
import work.dao.Dao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedWriter;
import java.io.IOException;

import java.util.List;

@WebServlet("/login")
public class Login extends HttpServlet {
    private Dao dao;
    private Service service;
    @Override
    public void init() {
        dao = Dao.getInstance();
        service=Service.getInstance();
    }

    @Override
            public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("application/json;charset=utf-8");
        response.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        int password = Integer.parseInt(request.getParameter("password"));
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        if(username!=null&&password!=0){
        try {
            if (service.isLogin(user)) {
                String result="登陆成功---可进行留言操作";
                response.getWriter().write(result);
                response.sendRedirect("/loginMain.jsp");
            } else {
                response.getWriter().write("登录失败---仅可查看留言板内容");
                response.sendRedirect("/falseLogin.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }}
        else{
            response.getWriter().write("登录失败");
        }
    }
}