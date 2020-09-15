package com.dao;

import com.domain.Detail;
import com.domain.Vuser;
import com.util.JdbcUtil;
import com.domain.Parking;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ParkingDaoImpl implements ParkingDao {
    @Override
    public List<Parking> findAll() throws Exception {
        String sql="Select * from parkinglot ";
        Connection con=JdbcUtil.connectionLink();
        PreparedStatement ps=con.prepareStatement(sql);
        ResultSet rs=ps.executeQuery();
        Parking p;
        List<Parking>list =new ArrayList<>();
        while (rs.next())
        {
            p=new Parking();
            p.setId(rs.getString("id"));
            p.setOnername(rs.getString(2));
            p.setPlatenum(rs.getString(3));
            p.setTel(rs.getString(4));
            list.add(p);
        }
        //关闭资源
        JdbcUtil.closeSource(con,ps,rs);
        return list;
    }
    @Override
    public List<Vuser> findv() throws Exception {
        String sql="Select * from vip";
        Connection con=JdbcUtil.connectionLink();
        PreparedStatement ps=con.prepareStatement(sql);
        ResultSet rs=ps.executeQuery();
        Vuser v;
        List<Vuser>list =new ArrayList<>();
        while (rs.next())
        {
            v=new Vuser();
            v.setVid(rs.getInt(1));
            v.setUser(rs.getString(2));
            v.setTel(rs.getString(3));
            list.add(v);
        }
        //关闭资源
        JdbcUtil.closeSource(con,ps,rs);
        return list;
    }
    @Override
    public boolean add(Vuser v) throws Exception {
        String sql = "INSERT  into vip(User,Tel)VALUE (?,?)";
        Connection con = JdbcUtil.connectionLink();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, v.getUser());
        ps.setString(2, v.getTel());
        int i = ps.executeUpdate();
         JdbcUtil.closeSource(con,ps);
        if (i > 0) {
            return true;
        } else return false;
    }

    @Override
    public boolean add(Parking p) throws Exception {
        String sql = "INSERT  into parkinglot(id,ownername,platenum,tel)VALUE (?,?,?,?)";
        Connection con = JdbcUtil.connectionLink();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1,p.getId());
        ps.setString(2, p.getOnername());
        ps.setString(3, p.getPlatenum());
        ps.setString(4, p.getTel());
        int i = ps.executeUpdate();

        String sql2= "INSERT into detail(id,begin)value(?,?)";
        PreparedStatement ps2=con.prepareStatement(sql2);
        Date date=new Date();
        //自动获取当前时间，转换格式储存在数据库中
        Timestamp timeStamp = new Timestamp(date.getTime());
//        System.out.println(timeStamp);
        ps2.setString(1,p.getId());
        ps2.setTimestamp(2,timeStamp);
        int j = ps2.executeUpdate();
        JdbcUtil.closeSource(con,ps);
        if (i > 0&&j>0) {
            return true;
        } else return false;
    }

    @Override
    public void delete(String userId) throws Exception {
        String sql="Delete from parkinglot where id=?";
        String sql2="Delete from detail where id=?";
        Connection con=JdbcUtil.connectionLink();
        PreparedStatement ps=con.prepareStatement(sql);
        PreparedStatement ps2=con.prepareStatement(sql2);
        ps.setString(1, userId);
        ps2.setString(1,userId);
        ps.executeUpdate();
        ps2.executeUpdate();
        //关闭资源
        JdbcUtil.closeSource(con,ps);
        ps2.close();
    }

    @Override
    public void deletev(int userId) throws Exception {
        String sql="Delete from vip where Vid=?";
        Connection con=JdbcUtil.connectionLink();
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setInt(1, userId);
        ps.executeUpdate();
        //关闭资源
        JdbcUtil.closeSource(con,ps);
    }

    @Override
    public boolean up(Parking p) throws Exception {
        String sql="UPDATE parkinglot set ownername=?,platenum=?,tel=? WHERE id=?";
        Connection con=JdbcUtil.connectionLink();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, p.getOnername());
        ps.setString(2, p.getPlatenum());
        ps.setString(3, p.getTel());
        ps.setString(4,p.getId());
        int i = ps.executeUpdate();
        JdbcUtil.closeSource(con,ps);
        if (i > 0) {
            return true;
        } else return false;
    }

    @Override
    public boolean up(Vuser v) throws Exception {
        String sql="UPDATE vip set User=?,Tel=? WHERE Vid=?";
        Connection con=JdbcUtil.connectionLink();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, v.getUser());
        ps.setString(2, v.getTel());
        ps.setInt(3,v.getVid());
        int i = ps.executeUpdate();
        JdbcUtil.closeSource(con,ps);
        if (i > 0) {
            return true;
        } else return false;
    }

    @Override
    public Detail showDetail(String id) throws Exception {
        String sql="SELECT * from detail where id=?";
        Connection con = JdbcUtil.connectionLink();
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setString(1,id);
        ResultSet rs = ps.executeQuery();
        rs.next();
        Detail de=new Detail();
        de.setId(id);
        de.setBegin(rs.getTimestamp(2));
        de.setEnd(rs.getTimestamp(3));
        de.setDuration(rs.getString(4));
        de.setVuser(rs.getString(5));
        de.setCharge(rs.getString(6));
        JdbcUtil.closeSource(con,ps,rs);
        return de;
    }

    @Override
    public void setEndTime(String id) throws Exception {
        Detail de=showDetail(id);
        Timestamp timestamp1=de.getBegin();
        String sql="UPDATE detail SET end =?,duration=? where id=?";
        Connection con = JdbcUtil.connectionLink();
        PreparedStatement ps=con.prepareStatement(sql);
        Date date=new Date();
        //自动获取当前时间，转换格式储存在数据库中
        Timestamp timeStamp2 = new Timestamp(date.getTime());
        //计算时间差值
        String du=Detail.getTimeDifference(timeStamp2,timestamp1);
        ps.setTimestamp(1,timeStamp2);
        ps.setString(2,du);
        ps.setString(3,id);
        ps.executeUpdate();
        JdbcUtil.closeSource(con,ps);
    }

    @Override
    public void setCharge(String userId,String Tel) throws Exception {
        //获取用户具体信息
        Detail de=showDetail(userId);
        String h=de.getDuration();
        String sql="SELECT * FROM  vip where Tel=?";
        Connection con = JdbcUtil.connectionLink();
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setString(1,Tel);
        ResultSet res = ps.executeQuery();
//        res.next();
        //判断是否在vip中查询到用户
        //停车场每小时停车3元,vip用户八折
        double discount=1;
        String vuser="否";
        if(res.next())
        {
            discount=0.8;
            vuser="是";
        }
        double  charge=3*(Double.valueOf(h))*discount;
        //保留两位
        BigDecimal b = new BigDecimal(charge);
        charge = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
//        System.out.println(h);
//        System.out.println(charge);
        String ch=charge+"";
        //将停车费用写入数据库
        String sql2="UPDATE detail SET charge=?,vuser=? WHERE id=?";
        PreparedStatement ps2=con.prepareStatement(sql2);
        ps2.setString(1,ch);
        ps2.setString(2,vuser);
        ps2.setString(3,userId);
        ps2.executeUpdate();
        //关闭资源
        JdbcUtil.closeSource(con,ps,res);
        ps2.close();
    }
}