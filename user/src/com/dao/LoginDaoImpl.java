package com.dao;

import com.domain.User;
import com.util.JdbcUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginDaoImpl implements LoginDao {
    @Override
    public User LoginUsernamePassword(String username, String password) {
        User user=new User();
        JdbcUtil jdbcUtil=new JdbcUtil();
        Connection connection = null;
        Statement statement=null;
        ResultSet resultSet=null;
        try {
            //1.连接驱动
            connection = jdbcUtil.connectionLink();
            //2.创建执行对象和sql语句
             statement=connection.createStatement();
            String  sql="SELECT username,password FROM  USER WHERE username='"+username+"'and password='"+password+"'";
            resultSet = statement.executeQuery(sql);
            while (resultSet.next())
            {
                String username1=resultSet.getString(1);
                String password1=resultSet.getString(2);
                user.setUsername(username1);
                user.setPassword(password1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            //关闭资源
            jdbcUtil.closeSource(connection,statement,resultSet);
        }
        return user;
    }
}
