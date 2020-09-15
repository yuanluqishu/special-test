package com.domain;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class Detail {
    private String id;
    private Timestamp begin;
    private Timestamp end;
    private String duration;
    private String charge;
    private String vuser;

    public void setVuser(String vuser) {
        this.vuser = vuser;
    }

    public String getVuser() {
        return vuser;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setBegin(Timestamp begin) {
        this.begin = begin;
    }

    public void setEnd(Timestamp end) {
        this.end = end;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void setCharge(String charge) {
        this.charge = charge;
    }

    public Timestamp getBegin() {
        return begin;
    }

    public Timestamp getEnd() {
        return end;
    }

    public String getDuration() {
        return duration;
    }

    public String getCharge() {
        return charge;
    }

    public static String getTimeDifference(Timestamp formatTime1, Timestamp formatTime2) {
        SimpleDateFormat timeformat = new SimpleDateFormat("yyyy-MM-dd,HH:mm:ss");
        long t1 = formatTime1.getTime();
        long t2 = formatTime2.getTime();
        int hours=(int) ((t1 - t2)/(1000*60*60));
        int minutes=(int) (((t1 - t2)/1000-hours*(60*60))/60);
        double re=hours+minutes/60.0;
        BigDecimal b = new BigDecimal(re);
        /*setScale 第一个参数为保留位数 第二个参数为舍入机制
         BigDecimal.ROUND_UP表示进位*/
        re = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        return ""+re;
    }
}
