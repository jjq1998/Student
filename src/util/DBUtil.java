package util;

import constants.AppConstants;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil
{
    /**
     * 与数据库建立连接的方法
     * @return connection 数据库连接
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static Connection getConnection() throws ClassNotFoundException, SQLException
    {
        Class.forName(AppConstants.JDBC_DRIVER_ADDRESS);
        Connection connection = DriverManager.getConnection(AppConstants.JDBC_URL, AppConstants.JDBC_USER, AppConstants.JDBC_PASSWORD);
        return connection;
    }

    public static void closeAll(AutoCloseable... autoCloseables) throws Exception
    {
        for (AutoCloseable param : autoCloseables)
        {
            if (param != null)
            {
                param.close();
            }
        }
    }
}
