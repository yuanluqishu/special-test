package pojo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class InserJdbc {
    public static void main(String[] args) throws Exception {
        //1.加载驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2.创建连接
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/data?serverTimezone=UTC&useSSL=false", "admin", "123");

        //3.定义sql
        String  sql="INSERT USER VALUE ('zhang','123')";

        //4.创建执行sql的对象
        Statement statement=connection.createStatement();

        //5.执行sql
        int i = statement.executeUpdate(sql);

        //6.释放资源
        connection.close();
        statement.close();
    }
}
