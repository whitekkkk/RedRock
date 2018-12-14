package Http;

import JDBC.JDBC;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class Httpj {

  public static String Json(String m) {
      StringBuilder json = new StringBuilder();
      try {//获取JSON字符串
          URL url = new URL("http://jwzx.cqupt.edu.cn/data/json_StudentSearch.php?searchKey="+m);
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
  public static void aa (String m)throws Exception
  {//将JSON对象中的学号取出放入list集合
        JDBC jdbc=new JDBC();
        jdbc.Jdbc();
        List<String> list = new ArrayList<String>();
        String str =Json(m);
        JSONObject obj = JSONObject.fromObject(str);
        String aa = obj.getString("returnData");
        JSONArray json1 = JSONArray.fromObject(aa);
        for (int l = 0; l < json1.size(); l++) {
            JSONObject job = json1.getJSONObject(l);
            String bb = job.getString("xh");
            System.out.println(bb);
            list.add(bb);
        }
        jdbc.insert(list);
        jdbc.close();
  }
}
