package servlet;

import model.Message;
import service.Service;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/ChangeMessage")
public class MessageServlet extends HttpServlet {
    private Service service;
    @Override
    public void init()
    {
        service=Service.getInstance();
    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
    {
        String username=request.getParameter("username");
        String text=request.getParameter("text");
        int pid = Integer.parseInt(request.getParameter("pid"));
        Message message=new Message();
        message.setUsername(username);
        message.setText(text);
        message.setPid(pid);
        try{
            if(service.isSuccess(message))
            {
                response.getWriter().write("留言成功");
            }
            else{
                response.getWriter().write("留言失败");
            }
        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
