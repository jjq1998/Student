package dao;

import bean.User;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO
{
    public static User select(String username, String password) throws Exception
    {
        String sql = "SELECT name,username,password from admin WHERE username = ? AND password = ?";
        Connection connection = DBUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,username);
        preparedStatement.setString(2,password);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next())
        {
            User user = new User();
            user.setName(resultSet.getString("name"));
            user.setUserName(resultSet.getString("username"));
            user.setPassword(resultSet.getString("password"));
            DBUtil.closeAll(resultSet,preparedStatement,connection);
            return user;
        }
        DBUtil.closeAll(resultSet,preparedStatement,connection);
        return null;
    }
}
