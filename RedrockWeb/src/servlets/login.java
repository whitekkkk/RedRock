package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

public class login extends HttpServlet {
    private Connection con;
    private ResultSet rs;
    private PreparedStatement pstm;
    @Override
    public void init() throws ServletException {//获取驱动和链接
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/redrock?serverTimezone=GMT%2B8", "root", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");//从URL中获取username
        String password = request.getParameter("password");//从URL中获取password
        response.setContentType("application/json;charset=utf-8");
        response.setCharacterEncoding("UTF-8");
        try {
            String sql = "select * from user where username=?";
            pstm=con.prepareStatement(sql);
            pstm.setString(1,username);
            rs = pstm.executeQuery();
            if (rs.next()) {//判断获得的用户名和密码是否存在于数据库中
                response.getWriter().write("用户名正确.....正在检查密码.....\n");
                if(password.equals(rs.getString("password")))
                {
                    response.getWriter().write("密码正确，登陆成功");
                }
                else{
                    response.getWriter().write("密码错误，登录失败");
                }
            } else {
                response.getWriter().write("用户名不存在");
            }
            rs.close();//关闭链接
            pstm.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
