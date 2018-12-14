package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

public class register extends HttpServlet {
    private Connection con;
    @Override
    public void init()throws ServletException
    {
        try {//获取驱动和链接
            Class.forName("com.mysql.cj.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost/redrock","root","");
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        String username = request.getParameter("username");//从URL中获取username
        String password = request.getParameter("password");//从URL中获取password
        response.setContentType("application/json;charset=utf-8");
        response.setCharacterEncoding("UTF-8");
        if (username != null && password != null) {//判断输入是否标准
            try {//将数据上传到数据库
                String sql = "insert into user(username,password) values(?,?)";
                PreparedStatement pstmt = con.prepareStatement(sql);
                pstmt.setString(1, username);
                pstmt.setString(2, password);
                pstmt.executeUpdate();
                con.close();//关闭链接
                pstmt.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            response.getWriter().write("注册成功");
        }
        else{
            response.getWriter().write("注册失败");
        }
    }
}
