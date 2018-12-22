package work.dao;
import model.Message;
import model.User;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Dao {
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/redrock?characterEncoding=utf-8&useSSL=true&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASS = "";

    private static Dao instance;

    public static Dao getInstance()
    {
           if(instance==null)
        synchronized(Dao.class)
        {
               if(instance==null)
            {
                instance=new Dao();
            }
        }
        return instance;
    }


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
    public void insert(Message message)//插入留言
    {
        Connection con=getConnection();
        PreparedStatement pstmt=null;
        String sql="insert into message_board (username,text,pid) values(?,?,?)";
        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1,message.getUsername());
            pstmt.setString(2,message.getText());
            pstmt.setInt(3,message.getPid());
            pstmt.executeUpdate();
            pstmt.close();
            con.close();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public void register(User user)//注册
    {
        Connection con=getConnection();
        PreparedStatement pstmt=null;
        String sql="insert into  user(username,password) values(?,?)";
        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1,user.getUsername());
            pstmt.setInt(2,user.getPassword());
            pstmt.executeUpdate();
            con.close();
            pstmt.close();
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public boolean login(User user)throws SQLException
    {
        ResultSet rs=null;
        Connection con=null;
        PreparedStatement pstmt=null;
        String sql="select * from user where username=?";
            con=getConnection();
            pstmt=con.prepareStatement(sql);
            pstmt.setString(1,user.getUsername());
            rs=pstmt.executeQuery();
            if(rs.next())
            {
                if(user.getPassword()==rs.getInt("password"))
                {
                    con.close();
                    pstmt.close();
                    rs.close();
                  return true;
                }
                else{
                    con.close();
                    pstmt.close();
                    rs.close();
                    return false;
                }

            }
            else{
                con.close();
                pstmt.close();
                rs.close();
                    return false;
            }
    }


    public List<Message> findPid(int pid)//寻找父节点
    {
        ResultSet rs=null;
        PreparedStatement pstmt=null;
        Connection con=getConnection();
        String sql="select * from message_board where pid=?";
        List<Message> list =new ArrayList<Message>();
        try{
        pstmt=con.prepareStatement(sql);
        pstmt.setInt(1,pid);
        rs=pstmt.executeQuery();
        while(rs.next())
        {
            Message message=new Message();
            message.setId(rs.getInt("id"));
            message.setText(rs.getString("text"));
            message.setUsername(rs.getString("username"));
            message.setPid(rs.getInt("pid"));
            list.add(message);
        }
        con.close();
        pstmt.close();
        rs.close();
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return list;
    }
}
