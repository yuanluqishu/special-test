package com.View;

import com.dao.ParkingDao;
import com.dao.ParkingDaoImpl;
import com.domain.Parking;
import com.domain.Vuser;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Timestamp;
import java.util.List;

public class JpanelQuery extends JPanel {
    private  JTable table;
    private DefaultTableModel model;
    private ParkingDao pd;

    public JpanelQuery(Parking p) {
        setLayout(new BorderLayout(0, 0));

        //创建滚动窗
        JScrollPane scrollPane = new JScrollPane();
        //把滚动窗添加到Panel中，居中显示
        add(scrollPane, BorderLayout.CENTER);
        table = new JTable();
        //添加表格到滚动窗
        scrollPane.setColumnHeaderView(table);

        //初始化表格
        model = new DefaultTableModel(new Object[][]{}, new String[]{"id", "车主姓名", "车牌号码", "联系方式"});
        //添加model到table
        table.setModel(model);
        //设置table高度
        table.setRowHeight(50);
        //设置table可见
        scrollPane.setViewportView(table);
        loadDatap();
    }
    public JpanelQuery(Object v) {
        setLayout(new BorderLayout(0, 0));

        //创建滚动窗
        JScrollPane scrollPane = new JScrollPane();
        //把滚动窗添加到Panel中，居中显示
        add(scrollPane, BorderLayout.CENTER);
        table = new JTable();
        //添加表格到滚动窗
        scrollPane.setColumnHeaderView(table);

        //初始化表格
        model = new DefaultTableModel(new Object[][]{}, new String[]{"id", "会员姓名", "预留号码"});
        //添加model到table
        table.setModel(model);
        //设置table高度
        table.setRowHeight(50);
        //设置table可见
        scrollPane.setViewportView(table);
        loadDatav();
    }
        void  loadDatap()
    {
        model.getDataVector().clear();
        //从数据库获取数据
        pd=new ParkingDaoImpl();
        List<Parking>list= null;
        try {
            list = pd.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for(Parking p:list)
        {
            model.addRow(new Object[]{p.getId(),p.getOnername(),p.getPlatenum(),p.getTel()});
        }
    }
    void  loadDatav()
    {
        model.getDataVector().clear();
        //从数据库获取数据
        pd=new ParkingDaoImpl();
        List<Vuser>list= null;
        try {
            list = pd.findv();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for(Vuser v:list)
        {
            model.addRow(new Object[]{v.getVid(),v.getUser(),v.getTel()});
        }
    }
    public void del(Object temp) throws Exception {
        //判断是否选中行
        if(table.getSelectedRowCount()<=0)
        {
            JOptionPane.showMessageDialog(null,"请先选择要删除的数据行");
            return;
        }
        //点击删除后弹出对话框，询问是否确认删除
        int i = JOptionPane.showConfirmDialog(null, "是否确认删除？");
        //判断是否点击确认
        if(i==JOptionPane.YES_OPTION)
        {
           //获取点击行的第一个数据（id）
           //直接调用Dao进行删除然后回显
            if(temp instanceof Vuser)
            {
                int userId = (int)table.getValueAt(table.getSelectedRow(), 0);
                pd.deletev(userId);
                loadDatav();
            }
            else if(temp instanceof  Parking)
            {
               String userId = (String) table.getValueAt(table.getSelectedRow(), 0);
                pd.delete(userId);
                loadDatap();
            }
        }
    }
     public String getId()
     {
         String userId=(String) table.getValueAt(table.getSelectedRow(),0);
         return userId;
     }
     public int getUid()
     {
         int userId=(int) table.getValueAt(table.getSelectedRow(),0);
         return userId;
     }
     public String getTel()
     {
         String tel=(String) table.getValueAt(table.getSelectedRow(),3);
         return tel;
     }
    }

