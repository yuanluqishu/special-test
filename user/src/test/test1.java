package test;

import javax.swing.*;
import java.awt.*;

public class test1 extends JFrame {
    test1()
    {
        new Frame("流布局");
        Container con=getContentPane();
        setLayout(new FlowLayout(0,10,10));
        for (int i=0;i<20;i++)
        {
            add(new JButton("BUTTON"+i));
        }
        this.setVisible(true);
        this.setBounds(200,200,300,300);
    }

    public static void main(String[] args) {
        new test1();
    }
}
