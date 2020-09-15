package com.View;

import com.dao.ParkingDao;
import com.dao.ParkingDaoImpl;
import com.domain.Detail;
import com.domain.Parking;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;

public class JpanelDetail extends JPanel{
    private JFrame jFrame;
    private JTable tab;
    private DefaultTableModel mod;
    private ParkingDaoImpl pd=new ParkingDaoImpl();

    public JFrame getjFrame() {
        return jFrame;
    }

    public JpanelDetail() {
        jFrame=new JFrame("详细信息");
        //创建滚动窗
        JScrollPane scrollPane = new JScrollPane();
   //     把滚动窗添加到Panel中，居中显示
        this.add(scrollPane, BorderLayout.CENTER);
        jFrame.add(this);
        jFrame.setBounds(450,450,700,140);
        this.setSize(700,70);
         tab=new JTable();
//        //添加表格到滚动窗
        scrollPane.setColumnHeaderView(tab);
        //初始化表格
        mod= new DefaultTableModel(new Object[][]{}, new String[]{"起始时间", "结束时间", "停车时长","是否会员","应缴费用(元）"});

        //添加model到table
        tab.setModel(mod);
        //设置table高度
        tab.setRowHeight(50);
        //设置列宽宽度
        tab.getColumnModel().getColumn(0).setPreferredWidth(90);
        tab.getColumnModel().getColumn(1).setPreferredWidth(90);
        tab.getColumnModel().getColumn(2).setPreferredWidth(40);
        tab.getColumnModel().getColumn(3).setPreferredWidth(40);
        tab.getColumnModel().getColumn(4).setPreferredWidth(50);
        scrollPane.setViewportView(tab);
        jFrame.setVisible(false);
    }
    public void showD(String userId)
    {
        try {
            //获取信息
            Detail de = pd.showDetail(userId);
            mod.getDataVector().clear();
            mod.addRow(new Object[]{de.getBegin(),de.getEnd(),de.getDuration(),de.getVuser(),de.getCharge()});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void end(String userId,String tel) throws Exception {
        pd.setEndTime(userId);
        pd.setCharge(userId,tel);//计算价格需要判断是否vip用户，vip用户的唯一标识是tel
    }


}
