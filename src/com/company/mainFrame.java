package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class mainFrame extends JFrame implements ActionListener {
    JRadioButton teacher, student;
    JButton b1;
    ButtonGroup options;
    mainFrame(){
        setBounds(0,0,1375,768);

        getContentPane().setBackground(Color.pink);
        setTitle("DSU Quiz");
        setLayout(null);
        setVisible(true);

        //teacher radio button

        teacher = new JRadioButton("Teacher");
        teacher.setBounds(400, 200, 100, 30);
        teacher.setFont(new Font("Dialog", Font.PLAIN, 20));
        teacher.setBackground(Color.WHITE);
        add(teacher);

        //student radio button

        student = new JRadioButton("Student");
        student.setBounds(700, 200, 100, 30);
        student.setFont(new Font("Dialog", Font.PLAIN, 20));
        student.setBackground(Color.WHITE);
        add(student);

        b1 = new JButton("Continue to logIn");
        b1.setBounds(450,350,300,40);
        b1.addActionListener(this);
        add(b1);

        options = new ButtonGroup();
        options.add(teacher);
        options.add(student);

    }
    public void actionPerformed(ActionEvent e){

        if(e.getSource() == b1){
            if(options.getSelection() == null){
                JOptionPane.showMessageDialog(this, "Please Chose Any One");
            }

            else if(teacher.isSelected()){
                setVisible(false);
                new teacherLogIn();
            }
            else{
                setVisible(false);
                new studentLogIn();
            }

        }

    }

    public static void main(String[] args) {
        new mainFrame();
    }
}