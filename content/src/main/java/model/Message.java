package model;

import java.util.List;

public class Message {
    private String username;//用户名
    private int id;//编号
    private int pid;//父结点
    private String text;//留言内容
    private List<Message> childContent;//获取一个留言数据的集合


//setter,getter
    public void setPid(int pid) {
        this.pid = pid;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setChildContent(List<Message> childContent) {
        this.childContent = childContent;
    }

    public String getUsername() {
        return username;
    }

    public int getPid() {
        return pid;
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public List<Message> getChildContent() {
        return childContent;
    }
}
