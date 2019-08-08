package dao;

import bean.Student;
import constants.AppConstants;
import util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO
{
    private final static int COLUMNNUM = 11;
    public static String[][] selectAll() throws Exception
    {
        Connection connection = DBUtil.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(AppConstants.STUDENT_SELECTALL_SQL);
        List<Student> list = new ArrayList<>();
        while (resultSet.next())
        {
            Student student = new Student();
            student.setSno(resultSet.getInt(1));
            student.setName(resultSet.getString(2));
            student.setSex(resultSet.getString(3));
            student.setBirth(resultSet.getString(4));
            student.setAddress(resultSet.getString(5));
            student.setDormitory(resultSet.getString(6));
            student.setTel(resultSet.getString(7));
            student.setDuty(resultSet.getString(8));
            student.setGrade(resultSet.getInt(9));
            student.setClassName(resultSet.getString(10));
            student.setAcademy(resultSet.getString(11));
            list.add(student);
        }
        String[][] result = new String[list.size()][COLUMNNUM];
        for (int j = 0;j < list.size();j++)
        {
            Student stu = list.get(j);
            result[j][0] = String.valueOf(stu.getSno());
            result[j][1] = stu.getName();
            result[j][2] = stu.getSex();
            result[j][3] = stu.getBirth();
            result[j][4] = stu.getAddress();
            result[j][5] = stu.getDormitory();
            result[j][6] = stu.getTel();
            result[j][7] = stu.getDuty();
            result[j][8] = String.valueOf(stu.getGrade());
            result[j][9] = stu.getClassName();
            result[j][10] = stu.getAcademy();
        }
        DBUtil.closeAll(resultSet,statement,connection);
        return result;
    }

    public static String[][] selectById(int sno) throws Exception
    {
        Connection connection = DBUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(AppConstants.STUDENT_SELECTBYID_SQL);
        preparedStatement.setInt(1,sno);
        ResultSet resultSet = preparedStatement.executeQuery();
        String[][] result = new String[1][StudentDAO.COLUMNNUM];
        if (resultSet.next())
        {
            result[0][0] = String.valueOf(resultSet.getInt(1));
            result[0][1] = resultSet.getString(2);
            result[0][2] = resultSet.getString(3);
            result[0][3] = resultSet.getString(4);
            result[0][4] = resultSet.getString(5);
            result[0][5] = resultSet.getString(6);
            result[0][6] = resultSet.getString(7);
            result[0][7] = resultSet.getString(8);
            result[0][8] = String.valueOf(resultSet.getInt(9));
            result[0][9] = resultSet.getString(10);
            result[0][10] = resultSet.getString(11);
        }
        DBUtil.closeAll(resultSet,preparedStatement,connection);
        return result;
    }

    public static void insert(int sno,int c_id,String name,String sex,String birth,String address,String dormitory,String tel,String duty) throws Exception
    {
        //`sno`, `c_id`, `name`, `sex`, `birth`, `address`, `dormitory`, `tel`, `duty`
        Connection connection = DBUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(AppConstants.STUDENT_INSERT_SQL);
        preparedStatement.setInt(1,sno);
        preparedStatement.setInt(2,c_id);
        preparedStatement.setString(3,name);
        preparedStatement.setString(4,sex);
        preparedStatement.setString(5,birth);
        preparedStatement.setString(6,address);
        preparedStatement.setString(7,dormitory);
        preparedStatement.setString(8,tel);
        preparedStatement.setString(9,duty);
        preparedStatement.executeUpdate();
        DBUtil.closeAll(preparedStatement,connection);
    }

    public static int deleteByID(int sno) throws Exception
    {
        Connection connection = DBUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(AppConstants.STUDENT_DELETEBYID_SQL);
        preparedStatement.setInt(1,sno);
        int i = preparedStatement.executeUpdate();
        DBUtil.closeAll(preparedStatement,connection);
        return i;
    }

    public static int update(int sno,int c_id,String name,String sex,String birth,String address,String dormitory,String tel,String duty) throws Exception
    {
        Connection connection = DBUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(AppConstants.STUDENT_UPDATE_SQL);
        preparedStatement.setInt(1,c_id);
        preparedStatement.setString(2,name);
        preparedStatement.setString(3,sex);
        preparedStatement.setString(4,birth);
        preparedStatement.setString(5,address);
        preparedStatement.setString(6,dormitory);
        preparedStatement.setString(7,tel);
        preparedStatement.setString(8,duty);
        preparedStatement.setInt(9,sno);
        int i = preparedStatement.executeUpdate();
        DBUtil.closeAll(preparedStatement,connection);
        return i;
    }
}
