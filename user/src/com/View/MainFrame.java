package com.View;

import com.dao.ParkingDao;
import com.dao.ParkingDaoImpl;
import com.domain.Detail;
import com.domain.Parking;
import com.util.JdbcUtil;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.util.Date;

public class MainFrame extends TemFrame implements ActionListener {
  Parking p=new Parking();
  JButton btnEnd=new JButton("结束");
  JButton btnShow=new JButton("详情");

    @Override
    public void actionPerformed(ActionEvent e) {
        Parking p=new Parking();
        String s = e.getActionCommand();
//       System.out.println(s);
        if(s.equals("新建"))
        {
            panelBottom.removeAll();
            //抽离出Jpanel
             add=new JpanelAdd(p);
            panelBottom.add(add,BorderLayout.CENTER);
            contentPane.add(panelBottom,BorderLayout.CENTER);
            //更新界面
            panelBottom.updateUI();
        }
        else if(s.equals("查询"))
        {
            panelBottom.removeAll();
            //抽离出Jpanel
             query=new JpanelQuery(p);
            panelBottom.add(query,BorderLayout.CENTER);
            //更新界面
            panelBottom.updateUI();
        }
        else  if(s.equals("删除"))
        {
           if(query==null)
           {
               JOptionPane.showMessageDialog(null,"没有数据行被选中！");
           }
            try {
                query.del(p);
                load();
            } catch (Exception e1) {
                e1.printStackTrace();
            }

        }
        else if(s.equals("修改"))
        {
            if(query==null)
            {
                JOptionPane.showMessageDialog(null,"没有数据行被选中！");
            }
            try {
                panelBottom.removeAll();
                //设置新窗口
                JFrame frame1 =new JFrame("更新数据页面");
                frame1.setBounds(350,350,460,400);
                //设置更新数据面板
                JpanelUpdate ju=new JpanelUpdate(query.getId());
                ju.setBounds(300,300,400,400);
                frame1.add(ju);
                frame1.setVisible(true);
                load();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }

    }
    void load()
    {
        panelBottom.removeAll();
        //抽离出Jpanel
        query=new JpanelQuery(p);
        panelBottom.add(query,BorderLayout.CENTER);
        //更新界面
        panelBottom.updateUI();
    }
     MainFrame()
     {
         TemFrame("停车信息管理页面");
         panel.add(btnEnd);
         panel.add(btnShow);
         btnEnd.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 if(query==null)
                 {
                     JOptionPane.showMessageDialog(null,"没有数据行被选中！");
                     return;
                 }
                 try {
                     JpanelDetail jd=new JpanelDetail();
                     String id=query.getId();
                     String tel=query.getTel();
                     //判断是否已结束
                     if(endFlag(id))
                     {
                         JOptionPane.showMessageDialog(null,"停车已结束！不能重复");
                         return;
                     }
                     else  jd.getjFrame().setVisible(true);
                     //1.end（）录入结束时间、间隔时间和费用
                     //2.showD（）展示细节
                     jd.end(id,tel);
                     jd.showD(id);
                 } catch (Exception e1) {
                     e1.printStackTrace();
                 }
             }
         });
         btnShow.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 if(query==null)
                 {
                     JOptionPane.showMessageDialog(null,"没有数据行被选中！");
                     return;
                 }
                 JpanelDetail jd=new JpanelDetail();
                 try {
                     jd.getjFrame().setVisible(true);
                     String id=query.getId();
                     jd.showD(id);
                 } catch (Exception e1) {
                     e1.printStackTrace();
                 }
             }
         });
     }

    private boolean endFlag(String id) throws Exception {
        ParkingDaoImpl pd=new ParkingDaoImpl();
        Detail de=pd.showDetail(id);
        if(de.getEnd()!=null)return true;
        else return false;
    }


}
