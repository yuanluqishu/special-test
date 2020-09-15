package com.View;

import com.dao.ParkingDao;
import com.dao.ParkingDaoImpl;
import com.domain.Parking;
import com.domain.Vuser;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;


public class JpanelAdd extends JPanel {
      JpanelAdd(Parking p)
    {
    setLayout(null);

    JLabel jlName=new JLabel("车主姓名:");
    jlName.setBounds(100,40,80,30);
    add(jlName);

    JTextField txtName = new JTextField();
    txtName.setBounds(180,40,180,30);
    add(txtName);

    JLabel jlPnum=new JLabel("车牌号码:");
    jlPnum.setBounds(100,100,80,30);
    add(jlPnum);

    JTextField txtPnum=new JTextField();
    txtPnum.setBounds(180,100,180,30);
    add(txtPnum);

    JLabel jlTel=new JLabel("联系方式:");
    jlTel.setBounds(100,160,80,30);
    add(jlTel);

    JTextField txtTel = new JTextField();
    txtTel.setBounds(180,160,180,30);
    add(txtTel);

    JButton jbAdd=new JButton("添加信息");
    jbAdd.setBounds(180,230,100,30);
    add(jbAdd);

    jbAdd.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
           String name=txtName.getText();
           String pnum=txtPnum.getText();
           String tel=txtTel.getText();
           if(name.equals("")||pnum.equals("")||tel.equals(""))
           {
               JOptionPane.showMessageDialog(null,"信息不能为空，请重新输入");
               return;
           }

           //封装对象
            p.setOnername(name);
            p.setPlatenum(pnum);
            p.setTel(tel);
            //随机生成六位id
            Random random = new Random();
            String id="";
            for (int i=0;i<6;i++)
            {
                id+=random.nextInt(10);
            }
            p.setId(id);
           ParkingDao pd=new ParkingDaoImpl();//创建可数据库的对象
            try {
                if(pd.add(p))
                {
                    JOptionPane.showMessageDialog(null,"插入成功");
                    txtName.setText("");//置空
                    txtPnum.setText("");
                    txtTel.setText("");
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"插入失败");
                }
            } catch (Exception e1) {
                e1.printStackTrace();
            }

        }
    });
    }
      JpanelAdd(Vuser v)
    {
        setLayout(null);

        JLabel jlName=new JLabel("会员姓名:");
        jlName.setBounds(100,40,80,30);
        add(jlName);

        JTextField txtName = new JTextField();
        txtName.setBounds(180,40,180,30);
        add(txtName);

        JLabel jlTel=new JLabel("预留号码:");
        jlTel.setBounds(100,100,80,30);
        add(jlTel);

        JTextField txtTel = new JTextField();
        txtTel.setBounds(180,100,180,30);
        add(txtTel);

        JButton jbAdd=new JButton("添加信息");
        jbAdd.setBounds(180,170,100,30);
        add(jbAdd);

        jbAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name=txtName.getText();
                String tel=txtTel.getText();
                if(name.equals("")||tel.equals(""))
                {
                    JOptionPane.showMessageDialog(null,"信息不能为空，请重新输入");
                    return;
                }

                //封装对象
                v.setUser(name);
                v.setTel(tel);
                ParkingDao pd=new ParkingDaoImpl();
                try {
                    if(pd.add(v))
                    {
                        JOptionPane.showMessageDialog(null,"插入成功");
                        txtName.setText("");
                        txtTel.setText("");
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"插入失败");
                    }
                } catch (Exception e1) {
                    e1.printStackTrace();
                }

            }
        });
    }
}
