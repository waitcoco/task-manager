package video;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class MySQLHelper {
    public static final String url = "jdbc:mysql://127.0.0.1:3306/video"; //数据库连接
    public static final String name = "com.mysql.jdbc.Driver";   //程序驱动
    public static final String user = "root";  //用户名
    public static final String password = "jz199514"; //密码

    public Connection connection = null; // 数据库连接
    public PreparedStatement preparedStatement = null; // 待查询语句描述对象

    public MySQLHelper() {
        try {
            Class.forName(name);// 指定连接类型
            connection = DriverManager.getConnection(url, user, password);// 获取连接
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            this.connection.close();
            this.preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("关闭数据库出现问题！！");
            e.printStackTrace();
        }
    }

    public ResultSet query(String sql) {
        ResultSet resultSet = null;

        try {
            preparedStatement = connection.prepareStatement(sql); // 准备执行语句
            resultSet = preparedStatement.executeQuery();

        } catch (Exception e) {
            System.out.println("查询错误，请检查！！");
            e.printStackTrace();
        }
        return resultSet;
    }


    public boolean executeNonquery(String sql) {
        boolean flag = false;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();
            flag = true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

}

