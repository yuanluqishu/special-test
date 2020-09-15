package com.util;

import java.sql.*;

public class JdbcUtil
{
    private static String url;
    private static String user;
    private static String password;
    private static String driver;
    public static Connection connectionLink() throws Exception {
        Connection connection=null;
        //1.加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
        //2.连接驱动
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/data?serverTimezone=UTC&useSSL=false", "admin", "123");
            return connection;
    }

    /**
     *关闭连接，释放资源
     */
    public  static void closeSource(Connection con,Statement sta)
    {
        if(sta!=null) {
            try {
                sta.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(con!=null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static   void closeSource(Connection con,Statement sta,ResultSet res)
    {
        if(res!=null) {
            try {
                res.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(sta!=null) {
            try {
                sta.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(con!=null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
