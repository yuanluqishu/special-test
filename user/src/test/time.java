package test;

import com.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class time {
    public static void main(String[] args) throws Exception {
        Date date = new Date();
        Timestamp timeStamp = new Timestamp(date.getTime());
        System.out.println(timeStamp);
//        String sql = "insert into tesst(time) values(?)";
//        try {
//            Connection con = JdbcUtil.connectionLink();
//            PreparedStatement ps = con.prepareStatement(sql);
//            ps.setTimestamp(1, timeStamp);
//            ps.executeUpdate();
//        } catch(Exception e)
//        {
//            e.printStackTrace();
//
//        }
//    }
    }
}