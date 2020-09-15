package com.View;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public abstract class TemFrame extends JFrame implements ActionListener{
    //外部框
    JPanel contentPane;
    //内部框
    protected  JPanel panel;
    protected  JPanel panelBottom;
    //删
    protected   JButton btnDel;
    //查
    protected   JButton btnQuery;
    //增
    protected JButton btnAdd;
    //改
    protected   JButton btnUpdate;
    //查询面板
    protected JpanelQuery query;
    //添加面板
    protected JPanel add;
    protected void TemFrame(String title)
    {
        //设置外部框
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle(title);
        setBounds(400,400,500,400);
        setVisible(true);

        //外部框
        contentPane = new JPanel();
        //设置边框样式
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        contentPane.setLayout( new BorderLayout(10,10));
        setContentPane(contentPane);

        //构件顶部展示按钮的plane
        panel =new JPanel();
        //把顶部框设置为北部布局
        contentPane.add(panel, BorderLayout.NORTH);
        panel.setLayout(new FlowLayout(1,5,5));
        btnAdd=new JButton("新建");
        btnDel=new JButton("删除");
        btnUpdate=new JButton("修改");
        btnQuery=new JButton("查询");

        //设置监听标识符
        btnAdd.setActionCommand("新建");
        btnDel.setActionCommand("删除");
        btnUpdate.setActionCommand("修改");
        btnQuery.setActionCommand("查询");

        btnAdd.addActionListener(this);
        btnUpdate.addActionListener(this);
        btnQuery.addActionListener(this);
        btnDel.addActionListener(this);

        panel.add(btnAdd);
        panel.add(btnDel);
        panel.add(btnUpdate);
        panel.add(btnQuery);

        //定义内部下部组件
        panelBottom =new JPanel();
        panelBottom.setBackground(Color.LIGHT_GRAY);

        //居中布置下部数据布局
        contentPane.add(panelBottom,BorderLayout.CENTER);
        panelBottom.setLayout(new BorderLayout(0,0));
    }

}
