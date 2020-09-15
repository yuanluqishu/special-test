package com.View;

import com.dao.ParkingDao;
import com.dao.ParkingDaoImpl;
import com.domain.Parking;
import com.domain.Vuser;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JpanelUpdate extends JPanel {
       JpanelUpdate(String userId)
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

           JButton jbUp=new JButton("更新信息");
           jbUp.setBounds(180,230,100,30);
           add(jbUp);

           jbUp.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                   String name=txtName.getText();
                   String pnum=txtPnum.getText();
                   String tel=txtTel.getText();
                   if(name.equals("")||tel.equals("")||pnum.equals(""))
                   {
                       JOptionPane.showMessageDialog(null,"信息不能为空，请重新输入");
                       return;
                   }
                   //封装对象
                   Parking p=new Parking();
                   p.setOnername(name);
                   p.setPlatenum(pnum);
                   p.setTel(tel);
                   p.setId(userId);
                   ParkingDao pd=new ParkingDaoImpl();
                   try {
                       if(pd.up(p))
                       {
                           JOptionPane.showMessageDialog(null,"更新成功");
                           txtName.setText("");
                           txtPnum.setText("");
                           txtTel.setText("");
                       }
                       else
                       {
                           JOptionPane.showMessageDialog(null,"更新失败");
                       }
                   } catch (Exception e1) {
                       e1.printStackTrace();
                   }

               }
           });
       }
       JpanelUpdate(int userId)
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

           JButton jbAdd=new JButton("更新信息");
           jbAdd.setBounds(180,170,100,30);
           add(jbAdd);

           jbAdd.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                   String name=txtName.getText();
                   String tel=txtTel.getText();
                   //封装对象
                   Vuser v=new Vuser();
                   v.setVid(userId);
                   v.setUser(name);
                   v.setTel(tel);
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
                       if(pd.up(v))
                       {
                           JOptionPane.showMessageDialog(null,"更新成功");
                           txtName.setText("");
                           txtTel.setText("");
                       }
                       else
                       {
                           JOptionPane.showMessageDialog(null,"更新失败");
                       }
                   } catch (Exception e1) {
                       e1.printStackTrace();
                   }

               }
           });
       }

}

