package constants;

public class AppConstants
{
    //JDBC常量
    public static final String JDBC_DRIVER_ADDRESS = "com.mysql.jdbc.Driver";
    public static final String JDBC_URL = "jdbc:mysql://localhost:3306/student";
    public static final String JDBC_USER = "root";
    public static final String JDBC_PASSWORD = "txsb213";

    //登录界面
    public static final String LOGIN_TITLE = "登录界面";
    public static final String LOGIN_USERNAME = "<html><body><div style=\"color: black;font-size: 20px;font-family: '华文彩云';\" align=\"center\">用户名</div></body></html>";
    public static final String LOGIN_PASSWORD = "<html><body><div style=\"color: black;font-size: 20px;font-family: '华文彩云';\" align=\"center\">密\t码</div></body></html>";
    public static final String LOGIN_LOGO = "<html><body><div style=\"color: black;font-size: 50px;font-family: '华文彩云';\" align=\"center\">Login</div></body></html>";
    public static final String LOGIN_BACKGROUND_URL = "E:\\WorkSpace\\IntelliJIDEA\\Student\\src\\view\\timg.jpg";
    public static final String LOGIN = "登录";
    public static final String RESET = "重置";

    //主界面
    public static final String MAIN_TITLE = "学生信息主界面";
    public static final String MAIN_FIND = "查询";
    public static final String MAIN_INSERT = "添加";
    public static final String MAIN_DELETE = "删除";
    public static final String MAIN_UPDATE = "更改";
    public static final String MAIN_RESULT_SELECT = "查询成绩";
    public static final String MAIN_RESULT_INSERT = "添加成绩";
    public static final String MAIN_FRESH = "刷新";
    public static final String[] MAIN_COLUMNNAME = {"学号","姓名","性别","生日","家庭住址","寝室","电话","职务","年级","班级","所在学院"};

    //添加界面
    //`sno`, `c_id`, `name`, `sex`, `birth`, `address`, `dormitory`, `tel`, `duty`
    public static final String INSERT_TITLE = "添加界面";
    public static final String INSERT_OKBUTTON = "确定";
    public static final String INSERT_RESET = "重置";
    public static final String INSERT_SNO = "学号";
    public static final String INSERT_C_ID = "班级号";
    public static final String INSERT_NAME = "姓名";
    public static final String INSERT_SEX = "性别";
    public static final String INSERT_BIRTH = "生日";
    public static final String INSERT_ADDRESS = "家庭住址";
    public static final String INSERT_DORMITORY = "寝室";
    public static final String INSERT_TEL = "电话";
    public static final String INSERT_DUTY = "职务";

    //删除界面
    public static final String DELETE_TITLE = "删除界面";
    public static final String DELETE_SNO = "学号";
    public static final String DELETE_BUTTON = "确定";

    //成绩查询界面
    public static final String RESULT_SELECT_TITLE = "成绩查询界面";
    public static final String[] RESULT_SELECT_COLUMN = {"姓名","课程名","分数"};
    public static final String[] RESULT_SELECTAVG_COLUMN = {"课程号","课程名","平均分"};
    public static final String[] RESULT_SELECTCOUNT_COLUMN = {"姓名","课程名","分数","总人数"};

    //错误界面
    public static final String ERROR_TITLE = "错误";
    public static final String ERROR_TEXT = "您无权进行此操作";
    public static final String ERROR_TEXT2 = "数据输入错误";

    //StudentDAO的SQL语句
    public static final String STUDENT_SELECTALL_SQL = "SELECT new_student.sno,new_student.name,new_student.sex,new_student.birth,new_student.address,new_student.dormitory,new_student.tel,new_student.duty,t_class.grade,t_class.classname,academy.name FROM new_student,t_class,academy WHERE new_student.c_id = t_class.id AND t_class.a_id = academy.id";
    public static final String STUDENT_SELECTBYID_SQL = "SELECT new_student.sno,new_student.name,new_student.sex,new_student.birth,new_student.address,new_student.dormitory,new_student.tel,new_student.duty,t_class.grade,t_class.classname,academy.name FROM new_student,t_class,academy WHERE new_student.c_id = t_class.id AND t_class.a_id = academy.id AND new_student.sno = ?";
    public static final String STUDENT_INSERT_SQL = "INSERT INTO `student`.`new_student` (`sno`, `c_id`, `name`, `sex`, `birth`, `address`, `dormitory`, `tel`, `duty`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    public static final String STUDENT_DELETEBYID_SQL = "DELETE FROM new_student WHERE sno = ?";
    public static final String STUDENT_UPDATE_SQL = "UPDATE `student`.`new_student` SET `c_id` = ?, `name` = ?, `sex` = ?, `birth` = ?, `address` = ?, `dormitory` = ?, `tel` = ? ,`duty` = ? WHERE (`sno` = ?)";

    //ResultDAO的SQL语句
    public static final String RESULT_SELECTBYID_SQL = "SELECT new_student.name,course.name,result.mark FROM new_student,course,result WHERE sno = ? AND new_student.sno = result.s_id AND course.id = result.c_id";
    public static final String RESULT_INSERT_SQL = "INSERT INTO `student`.`result` (`s_id`, `c_id`, `mark`) VALUES (?, ?, ?)";
    public static final String RESULT_SELECTAVG_SQL = "SELECT course.id,course.name,AVG(result.mark) FROM course,result WHERE course.id = ?;";
    public static final String RESULT_SELECTCOUNT_SQL = "SELECT new_student.name,course.name,result.mark,count(new_student.name) FROM new_student,result,course WHERE course.id = ? AND course.id = result.c_id AND new_student.sno = result.s_id AND mark > ? GROUP BY new_student.name;";
}
