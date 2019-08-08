package dao;

import bean.Result;
import bean.ResultCont;
import constants.AppConstants;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ResultDAO
{
    public static String[][] selectById(int sno) throws Exception
    {
        String[][] strings = null;
        Connection connection = DBUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(AppConstants.RESULT_SELECTBYID_SQL);
        preparedStatement.setInt(1,sno);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Result> list = new ArrayList<>();
        while (resultSet.next())
        {
            Result result = new Result();
            result.setStudentName(resultSet.getString(1));
            result.setCourseName(resultSet.getString(2));
            result.setMark(resultSet.getInt(3));
            list.add(result);
        }
        strings = new String[list.size()][3];
        for (int j = 0;j < list.size();j++)
        {
            Result result = list.get(j);
            strings[j][0] = result.getStudentName();
            strings[j][1] = result.getCourseName();
            strings[j][2] = String.valueOf(result.getMark());
        }
        DBUtil.closeAll(resultSet,preparedStatement,connection);
        return strings;
    }

    public static String[][] selectAVG(int id) throws SQLException, ClassNotFoundException
    {
        String[][] strings = null;
        Connection connection = DBUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(AppConstants.RESULT_SELECTAVG_SQL);
        preparedStatement.setInt(1,id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next())
        {
            strings = new String[1][3];
            strings[0][0] = String.valueOf(resultSet.getInt(1));
            strings[0][1] = resultSet.getString(2);
            strings[0][2] = String.valueOf(resultSet.getInt(3));
        }
        return strings;
    }

    public static String[][] selectCount(int id,int mark) throws Exception
    {
        String[][] strings = null;
        Connection connection = DBUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(AppConstants.RESULT_SELECTCOUNT_SQL);
        preparedStatement.setInt(1,id);
        preparedStatement.setInt(2,mark);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<ResultCont> list = new ArrayList<>();
        while (resultSet.next())
        {
            ResultCont resultCont = new ResultCont();
            resultCont.setS_name(resultSet.getString(1));
            resultCont.setC_name(resultSet.getString(2));
            resultCont.setMark(resultSet.getInt(3));
            resultCont.setCount(resultSet.getInt(4));
            list.add(resultCont);
        }
        strings = new String[list.size()][4];
        for (int j = 0;j < list.size();j++)
        {
            ResultCont result = list.get(j);
            strings[j][0] = result.getS_name();
            strings[j][1] = result.getC_name();
            strings[j][2] = String.valueOf(result.getMark());
            strings[j][3] = String.valueOf(list.size());
        }
        DBUtil.closeAll(resultSet,preparedStatement,connection);
        return strings;
    }

    public static void insert(int sno,int c_id,int mark) throws Exception
    {
        Connection connection = DBUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(AppConstants.RESULT_INSERT_SQL);
        preparedStatement.setInt(1, sno);
        preparedStatement.setInt(2,c_id);
        preparedStatement.setInt(3,mark);
        preparedStatement.executeUpdate();
        DBUtil.closeAll(preparedStatement,connection);
    }
}
