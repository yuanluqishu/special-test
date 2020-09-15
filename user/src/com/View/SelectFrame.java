package com.View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectFrame extends JFrame{
   SelectFrame()
   {
       setTitle("选择页面");
       setBounds(450,450,400,300);
       JPanel jPanel=new JPanel();
       add(jPanel);
       jPanel.setLayout(null);
       jPanel.setSize(600,600);
       //设置进入用户页面和停车页面的按钮
       JButton btnUser =new JButton("会员用户管理");
       JButton btnPark =new JButton("停车信息管理");
       btnPark.setBounds(100,50,180,30);
       btnUser.setBounds(100,120,180,30);
       jPanel.add(btnPark);
       jPanel.add(btnUser);
       setVisible(true);

       //添加监听事件
       btnUser.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               new VuserFrame();
               dispose();
           }
       });
       btnPark.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               new MainFrame();
               dispose();
           }
       });
   }

}
