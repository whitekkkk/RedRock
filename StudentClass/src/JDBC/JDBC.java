package JDBC;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class JDBC {
    PreparedStatement pstm;
    Connection con;
    public void Jdbc()throws Exception {//链接驱动，创建JDBC链接；
       Class.forName("com.mysql.cj.jdbc.Driver");
       con = DriverManager.getConnection("jdbc:mysql://localhost/redrock?serverTimezone=GMT%2B8","root","");
    }

    public void insert(List<String> list)throws SQLException {
        List<String> list1;
        list1 = list;
        for (int i = 0; i < list1.size(); i++) {//将list集合中的学号遍历取出放入数据库
            String sql = "insert into student values(?,?)";
            pstm=con.prepareStatement(sql);
            pstm.setString(1,list1.get(i));
            pstm.setString(2,"1");
            pstm.executeUpdate();
        }

    }
    public void close()throws SQLException{//执行链接关闭
        pstm.close();
        con.close();
    }
}
