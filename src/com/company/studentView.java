package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class studentView extends dbCon implements ActionListener{
    JButton Back,Start;
    String name;
    studentView(String name){
        this.name = name;
        setBounds(0,0,1375,768);
        getContentPane().setBackground(Color.pink);
        setTitle("Student View");
        setLayout(null);

        JLabel text1 = new JLabel(name+" Welcome to DSU Quiz");
        text1.setForeground(new Color(30, 144, 255));
        text1.setBounds(250,60,900,45);
        text1.setFont(new Font("Mongolian Baiti",Font.BOLD,45));
        add(text1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("com/company/icons/dsu.jpeg"));
        JLabel l1 = new JLabel(i1);
        l1.setBounds(300, 150, 600, 340);
        add(l1);


        Back = new JButton("Back");
        Back.setBounds(350,600,100,40);
        Back.addActionListener(this);
        add(Back);

        Start = new JButton("Start");
        Start.setBounds(750,600,100,40);
        Start.addActionListener(this);
        add(Start);





        setVisible(true);


    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == Start){
            JOptionPane.showMessageDialog(this, "Good Luck..");
            setVisible(false);
            new start_quiz(name).setVisible(true);
        }
        else if(e.getSource() == Back){
            setVisible(false);
            new studentLogIn();
//            System.exit(0);
        }
    }


    public static void main(String[] args) {
        new studentView("");
    }
}
