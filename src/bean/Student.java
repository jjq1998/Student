package bean;

public class Student
{
    //学生有学号、姓名、性别、生日、家庭住址、寝室、电话、年级、班级、所在院系等信息
    private int sno;
    private String name;
    private String sex;
    private String birth;
    private String address;
    private String dormitory;
    private String tel;
    private String duty;
    private int grade;
    private String className;
    private String academy;

    public String getDuty()
    {
        return duty;
    }

    public void setDuty(String duty)
    {
        this.duty = duty;
    }


    public int getSno()
    {
        return sno;
    }

    public void setSno(int sno)
    {
        this.sno = sno;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getSex()
    {
        return sex;
    }

    public void setSex(String sex)
    {
        this.sex = sex;
    }

    public String getBirth()
    {
        return birth;
    }

    public void setBirth(String birth)
    {
        this.birth = birth;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getDormitory()
    {
        return dormitory;
    }

    public void setDormitory(String dormitory)
    {
        this.dormitory = dormitory;
    }

    public String getTel()
    {
        return tel;
    }

    public void setTel(String tel)
    {
        this.tel = tel;
    }

    public int getGrade()
    {
        return grade;
    }

    public void setGrade(int grade)
    {
        this.grade = grade;
    }

    public String getClassName()
    {
        return className;
    }

    public void setClassName(String className)
    {
        this.className = className;
    }

    public String getAcademy()
    {
        return academy;
    }

    public void setAcademy(String academy)
    {
        this.academy = academy;
    }
}
