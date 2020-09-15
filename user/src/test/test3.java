package test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class test3 extends JFrame {
    public static void main(String[] args) {
        JFrame jf=new JFrame("下拉菜单");
        jf.setSize(400,400);


        JPanel JP=new JPanel();
        JPanel Jp=new JPanel();
        Jp.setSize(400,100);
        Jp.setBackground(Color.blue);
        JP.setSize(400,300);
        JP.setBackground(Color.green);
        JP.setLocation(0,100);
        JP.setLayout(null);

        JComboBox jComboBox=new JComboBox(new Object[]{"1","2"});

        jComboBox.setSize(55,20);
        JP.add(jComboBox);
        jf.add(JP);
        jf.add(Jp);
        jf.setVisible(true);

        jComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange()==ItemEvent.SELECTED)
                {
                    String s=jComboBox.getSelectedItem().toString();
                    System.out.println(s);
                }
            }
        });
    }
}
