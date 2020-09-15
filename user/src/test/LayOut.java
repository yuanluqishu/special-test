package test;

import javax.swing.*;
import java.awt.*;

public class LayOut extends JFrame{
    String border[]=
            {
                    BorderLayout.NORTH,
                    BorderLayout.SOUTH,
                    BorderLayout.WEST,
                    BorderLayout.EAST,
                    BorderLayout.CENTER
            };
    String borderName[]={"NORTH","SOUTH","WEST","EAST", "CENTER"};

    public  LayOut()
    {
        this.setTitle("展示布局");
        Container con=this.getContentPane();
        this.setLayout(new BorderLayout());
        for(int i=0;i<5;i++)
        {
            con.add(border[i],new JButton(borderName[i]));

        }
        this.setVisible(true);
        this.setBounds(50,50,500,400);
    }

    public static void main(String[] args) {
      new LayOut();
    }

}
