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
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost/redrock","root","");
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        response.setContentType("application/json;charset=utf-8");
        response.setCharacterEncoding("UTF-8");
        if (username != null && password != null) {
            try {
                String sql = "insert into user(username,password) values(?,?)";
                PreparedStatement pstmt = con.prepareStatement(sql);
                pstmt.setString(1, username);
                pstmt.setString(2, password);
                pstmt.executeUpdate();
                con.close();
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
