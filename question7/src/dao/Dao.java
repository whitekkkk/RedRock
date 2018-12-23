package dao;

import model.Student;

import java.sql.*;

public class Dao {
        private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
        private static final String DB_URL = "jdbc:mysql://localhost:3306/redrock?characterEncoding=utf-8&useSSL=true&serverTimezone=UTC";
        private static final String USER = "root";
        private static final String PASS = "";

        static {//加载驱动
                try {
                        Class.forName(JDBC_DRIVER);
                }catch (Exception e)
                {
                        e.printStackTrace();
                }
        }

        public Connection getConnection()//获得链接
        {
                Connection con=null;
                try
                {
                        con= DriverManager.getConnection(DB_URL,USER,PASS);
                }catch (Exception e)
                {
                        e.printStackTrace();
                }
                return con;
        }
        public void select()throws SQLException
        {
                ResultSet rs;
                PreparedStatement pstmt;
                Connection con=getConnection();
                String sql="select * from student where studentId=?";
                pstmt=con.prepareStatement(sql);
                pstmt.setString(1,"2018214015");
                rs=pstmt.executeQuery();
                while(rs.next())
                {
                        System.out.println(rs.getString("name")+rs.getString("studentId")+rs.getString("classId")+rs.getString("major"));
                }
        }
        public void insert(Student student)throws SQLException {
                PreparedStatement pstmt;
                Connection con=getConnection();
                        String sql = "insert into student(name,studentId,classId,mojor) values(?,?,?,?)";
                        pstmt=con.prepareStatement(sql);
                        pstmt.setString(1,student.getName());
                        pstmt.setString(2,student.getStuId());
                        pstmt.setString(3,student.getClassId());
                        pstmt.setString(4,student.getMajor());
                        pstmt.executeUpdate();
                        pstmt.close();
                        con.close();
                }

        }


