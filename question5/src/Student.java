public class Student {
    private String name;
    private int stuId;
    private int workLv;

    public Student(String name,int stuId,int workLv)//构造方法
    {
        this.name=name;
        this.stuId=stuId;
        this.workLv=workLv;
    }
    public int getPoint(int point)//获得积分
    {
        int getPt=0;
        switch (point)
        {
            case 3:
                getPt=3;
            break;
            case 5:
                getPt=5;
            break;
            case 10:
                getPt=10;
            break;
            case 20:
                getPt=20;
            break;
        }
        return getPt;
    }
//getter,setter
    public void setName(String name) {
        this.name = name;
    }

    public void setWorkLv(int workLv) {
        this.workLv = workLv;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    public int getWorkLv()//获取作业等级
    {
        return workLv;
    }

    public int getStuId() {
        return stuId;
    }

    public String getName() {
        return name;
    }
}
