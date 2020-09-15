package test;

import com.util.JdbcUtil;

import java.sql.*;
import java.util.Scanner;

public class LoginTest {

/**
 * 练习：
 * 		* 需求：
 * 			1. 通过键盘录入用户名和密码
 * 			2. 判断用户是否登录成功
 */
public static void main(String[] args) {
    Scanner in=new Scanner(System.in);
    String username=null;
    String password=null;
    System.out.println("Input username:");
    username=in.nextLine();
    System.out.println("Input password:");
    password=in.nextLine();
    boolean flag=login1(username,password);
    if(flag)
    {
        System.out.println("登录成功！");
    }
    else
        System.out.println("登录失败！");
}

    public static boolean login2(String username, String password) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        JdbcUtil jdbcUtil = new JdbcUtil();
        try {
            connection = jdbcUtil.connectionLink();
            String sql = "SELECT * FROM  USER WHERE username=? AND  password=?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);
            resultSet = statement.executeQuery();
            return resultSet.next();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            jdbcUtil.closeSource(connection, statement, resultSet);
        }
         return  false;
    }
    public static boolean login1(String username ,String password){
        if(username == null || password == null){
            return false;
        }
        //连接数据库判断是否登录成功
        Connection conn = null;
        Statement stmt =  null;
        ResultSet rs = null;
        JdbcUtil jdbcUtil=new JdbcUtil();
        //1.获取连接
        try {
            conn =jdbcUtil.connectionLink() ;
            //2.定义sql                           '"+username+"'    '"+password+"'
            //select * from jdbc where username = 账号参数 and password = 密码参数
            String sql = "select * from USER where username = '"+username+"' and password = '"+password+"' ";
            System.out.println(sql);
            //3.获取执行sql的对象
            stmt = conn.createStatement();
            //4.执行查询
            rs = stmt.executeQuery(sql);
            return rs.next();//如果有下一行，则返回true

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            jdbcUtil.closeSource(conn, stmt, rs);
        }
        return false;
    }

}
