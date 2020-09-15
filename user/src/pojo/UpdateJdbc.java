package pojo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class UpdateJdbc {
    public static void main(String[] args) throws Exception {
        //1.加载驱动
        Class.forName("com.mysql.cj.jdbc.Driver");

        //2.连接驱动
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/data?serverTimezone=UTC&useSSL=false", "admin", "123");

        //3.创建sql对象
        Statement statement = connection.createStatement();

        //4.创建sql语句
        String sql = "Update user set username='zhang' where username='Zhang'";

        //5.执行sql语句
        int i = statement.executeUpdate(sql);
        System.out.println(i);

        //6.释放连接资源
        statement.close();
        connection.close();
    }
}
