package com.View;


import com.dao.LoginDaoImpl;
import com.domain.User;
import com.sun.org.apache.bcel.internal.generic.Select;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class LoginFrame {
    public static void main(String[] args) {
        //1.创建一个JFrame窗口
        JFrame frame =new JFrame("登录页面");
        frame.setBounds(400,400,510,400);

        //3.添加JPanel
        JPanel panel=new JPanel();
        frame.add(panel);
        panel.setLayout(null);

        //4.添加JLabel
        JLabel titile=new JLabel("停车场数据管理系统");
        JLabel user_lab=new JLabel("用户名：");
        JLabel password =new JLabel("密码：");
        titile.setBounds(110,10,400,70);
        Font font1=new Font("黑体",Font.PLAIN,35);//创建1个字体实例
        titile.setFont(font1);
        user_lab.setBounds(60,80,100,40);
        password.setBounds(60,160,100,40);
        Font font2=new Font("宋体",Font.PLAIN,18);
        user_lab.setFont(font2);
        password.setFont(font2);
        panel.add(titile);
        panel.add(user_lab);
        panel.add(password);

        //5.创建文本框和密码框
        JTextField user_Field=new JTextField();
        user_Field.setBounds(140,80,280,40);
        user_Field.setFont(font2);
        panel.add(user_Field);
        JPasswordField passwordField=new JPasswordField();
        passwordField.setBounds(140,160,280,40);
        panel.add(passwordField);
        
        //6.按钮
        JButton login_Button = new JButton("登录");
        login_Button.setBounds(140,220,85,30);
        panel.add(login_Button);
        JButton exit_Button =new JButton("退出");
        exit_Button.setBounds(290,220,85,30);
        panel.add(exit_Button);

        //7.给按钮添加点击事件
        exit_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Swing中有个工具包SwingUtils
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        //弹出确认退出窗口
                        int i = JOptionPane.showConfirmDialog(frame, "确定要退出吗？");
                        if(i==JOptionPane.YES_OPTION)
                        {
                            //点击‘是’确认退出
                            frame.dispose();
                        }
                    }
                });
            }
        });
         login_Button.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 //获取文本值的api
                 String username = user_Field.getText().trim();
                 String password =passwordField.getText().trim();
                 LoginDaoImpl loginDefine=new LoginDaoImpl();
                 User user = loginDefine.LoginUsernamePassword(username, password);
                 String username1=user.getUsername();
                 String passsword1=user.getPassword();
                 if(username.equals(username1)&&password.equals(passsword1))
                 {
                     new SelectFrame();
                     frame.dispose();
//                     System.out.println("登录成功");
                 }
                 else
                 {
                     System.out.println("登录失败");
                   JOptionPane.showMessageDialog(frame,"登录失败");
//                     JOptionPane.showConfirmDialog(frame,"登录失败");
                 }

             }
         });

        //2.开启frame界面可视化
        frame.setVisible(true);
    }
}
