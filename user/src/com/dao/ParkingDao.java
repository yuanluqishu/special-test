package com.dao;

import com.domain.Detail;
import com.domain.Parking;
import com.domain.Vuser;

import java.sql.ResultSet;
import java.util.List;

public interface ParkingDao {
    List<Parking> findAll() throws Exception;
    List<Vuser> findv() throws Exception;
     boolean add(Parking p) throws Exception;


    void delete(String userId) throws Exception;

    void deletev(int userId) throws Exception;

    boolean up(Parking p) throws Exception;

//    List<Parking> find() throws Exception;

    boolean add(Vuser v) throws Exception;

    boolean up(Vuser v) throws Exception;

    Detail showDetail(String id) throws Exception;

    void setEndTime(String userId) throws Exception;

    void setCharge(String userId,String Tel) throws Exception;
}
