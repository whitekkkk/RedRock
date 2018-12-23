package service;

import dao.Dao;
import model.Student;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Info11 {
    public static String Json() {
        StringBuilder json = new StringBuilder();
        try {//获取JSON字符串
            URL url = new URL("http://120.79.143.238/cqupt/query?search=20182100");
            URLConnection uc = url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream(), "utf-8"));
            String inputLine = null;
            while ((inputLine = in.readLine()) != null) {
                json.append(inputLine);
            }
            in.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json.toString();
    }
    public static void select ()throws Exception
    {
        Dao dao=new Dao();
        String str =Json();
        JSONObject obj = JSONObject.fromObject(str);
        String aa = obj.getString("results");
        JSONArray json = JSONArray.fromObject(aa);
        for (int i = 0; i < json.size(); i++) {
            Student stu=new Student();
            JSONObject info = json.getJSONObject(i);
            stu.setStuId(info.getString("stuNum"));
            stu.setName(info.getString("name"));
            stu.setClassId(info.getString("classNum"));
            stu.setMojor(info.getString("academy"));
            dao.insert(stu);
        }
    }
}
