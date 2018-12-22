package service;

import model.Message;

import model.User;
import work.dao.Dao;

import java.util.List;

public class Service {
    private Dao dao=Dao.getInstance();
    //得到Service单例对象;
    private static Service instance;

    public static Service getInstance()//锁
    {
        if(instance==null)
            synchronized(Service.class)
            {
                if(instance==null)
                {
                    instance=new Service();
                }
            }
        return instance;
    }

    public List<Message> findChild(Message content)//使用递归遍历分支
    {
        List<Message> list=dao.findPid(content.getId());
        for(Message message:list)
        {
            List<Message> list1=findChild(message);
            message.setChildContent(list1);
        }
        return list;
    }

    public List<Message> allMessage()//得到一个包含所有留言的集合
    {
        List<Message> list=dao.findPid(0);//得到所有父节点为0的留言
        for(Message message:list)
        {
            List<Message> list1=findChild(message);
            message.setChildContent(list1);
        }
        return list;
    }
    public boolean isSuccess(Message message)//判断留言是否成功
    {
        if(message.getUsername()==null)
            return false;
        else
        {
            dao.insert(message);
            return true;
        }
    }
    public boolean isRegister(User user)
    {
        if(user.getUsername()==null&&user.getPassword()==0){
            return false;
        }
        else{
            dao.register(user);
            return true;
        }
    }
    public boolean isLogin(User user)throws Exception {
            if (dao.login(user))
            {
                return true;
            }
            else{
                return false;
            }
    }
}