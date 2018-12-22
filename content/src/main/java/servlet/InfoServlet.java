package servlet;

import model.Message;

import net.sf.json.JSONArray;

import service.Service;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

@WebServlet("/ScanMessage")
public class InfoServlet extends HttpServlet {
    Service service;
    @Override
    public void init()
    {
        service=Service.getInstance();
    }
    @Override
        public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException
    {
        List<Message> list=service.allMessage();
        JSONArray jsonArray=JSONArray.fromObject(list);
        String str=jsonArray.toString();
        BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(
                        response.getOutputStream()
                )
        );
        writer.write(str);
        writer.flush();
        writer.close();
    }
}
