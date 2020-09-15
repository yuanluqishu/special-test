package test;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.event.ActionListener;

public class test2 extends JFrame implements ActionListener { //外部框
    JPanel contentPane;
    //内部框
    JPanel panel;
    JPanel panelBottom;
    //删
    private  JButton btnDel;
    //查
    private  JButton btnLoadData;
    //增
    private  JButton btnADD;
    //改
    private  JButton update;
    test2()
    {
    //设置外部框
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setTitle("想不到吧，我又回来啦");
    setBounds(100,100,546,383);

    setVisible(true);

//外部框
    contentPane = new JPanel();
//setBorder设置Jpanle的边框形式函数，6个参数分表代表边框，标题，标题对齐方式，标题的位置，标题字体，标题颜色
contentPane.setBorder( new EmptyBorder( 5,5,5,5));
// hgap ：返回里面定义组件的水平间距  ，vgap:返回组件的垂直距离
contentPane.setLayout( new BorderLayout(10,10));

    setContentPane(contentPane);


// 构件顶部展示按钮的plane
    panel = new JPanel();
//把顶部框设置为北部布局
contentPane.add(panel,BorderLayout.SOUTH);
panel.setLayout(new FlowLayout(1,5,5));

    btnLoadData = new JButton("获取数据");
//设置监听的标识符
btnLoadData.setActionCommand("查询");
panel.add(btnLoadData);

    btnDel = new JButton("删除用户");
btnDel.setActionCommand("删除");
panel.add(btnDel);

    btnADD = new JButton("添加用户");
btnADD.setActionCommand("添加");
panel.add(btnADD);

    update = new JButton("修改用户");
update.setActionCommand("修改");
panel.add(update);

//定义内部下部组件
//定义内部中心组件

    panelBottom = new JPanel();
panelBottom.setBackground(Color.LIGHT_GRAY);

//居中布置下部数据布局
contentPane.add(panelBottom,BorderLayout.CENTER);
panelBottom.setLayout(new BorderLayout(0,0));
        btnADD.addActionListener(this);
        btnDel.addActionListener(this);
        update.addActionListener(this);
        btnLoadData.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args) {
        new test2();
    }


}
