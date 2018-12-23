package model;

public class Student {
    private String name;
    private String stuId;
    private String classId;
    private String mojor;

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMojor(String mojor) {
        this.mojor = mojor;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getName() {
        return name;
    }

    public String getClassId() {
        return classId;
    }

    public String getStuId() {
        return stuId;
    }

    public String getMajor() {
        return mojor;
    }
}
