package com.View;

import com.domain.Vuser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VuserFrame  extends TemFrame{
    Vuser v=new Vuser();
    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
//        System.out.println(s);
        if(s.equals("新建"))
        {
            panelBottom.removeAll();
            add=new JpanelAdd(v);
            panelBottom.add(add, BorderLayout.CENTER);
            contentPane.add(panelBottom,BorderLayout.CENTER);
            panelBottom.updateUI();
        }
        else if(s.equals("查询"))
        {
            panelBottom.removeAll();
            //抽离出Jpanel
            query=new JpanelQuery(v);
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
                query.del(v);
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
                frame1.setBounds(350,350,460,300);
                //设置更新数据面板

                JpanelUpdate ju=new JpanelUpdate(query.getUid());
//                ju.VuserUpdate(query.getId());
                ju.setBounds(300,300,400,300);
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
        query=new JpanelQuery(v);
        panelBottom.add(query,BorderLayout.CENTER);
        //更新界面
        panelBottom.updateUI();
    }
       VuserFrame()
       {
           TemFrame("用户信息管理页面");
       }


    }

