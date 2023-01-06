package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class teacherLogIn extends dbCon implements ActionListener {
    JButton loginB,ExitB;
    JTextField text_name;
    JTextField text_passw;
    JLabel title,passw,name;

    teacherLogIn() {

          setBounds(0,0,1375,768);
          setTitle("Teacher logIn");

            getContentPane().setBackground(Color.pink);

            setLayout(null);

            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("com/company/icons/google-quiz.jpg"));

            JLabel l1 = new JLabel(i1);
            l1.setBounds(0,0,600,500);
            add(l1);
            setVisible(true);

            title = new JLabel("DSU Quiz");
            title.setBounds(750,60,300,45);
            title.setFont(new Font("Mongolian Baiti",Font.BOLD,45));
            add(title);

            name = new JLabel("UserName:");
            name.setBounds(750,150,200,40);
            name.setFont(new Font("Mongolian Baiti",Font.BOLD,20));
            add(name);

            text_name = new JTextField();
            text_name.setBounds(860,160,150,25);
            add(text_name);

            passw = new JLabel("Password:");
            passw.setBounds(750,220,300,45);
            passw.setFont(new Font("Mongolian Baiti",Font.BOLD,20));
            add(passw);
//
            text_passw = new JTextField();
            text_passw.setBounds(860,225,150,25);
            add(text_passw);

            loginB = new JButton("LogIn");
            loginB.setBounds(900,300,150,40);
            loginB.addActionListener(this);
            add(loginB);

            ExitB = new JButton("Exit");
            ExitB.setBounds(750,300,150,40);
            ExitB.addActionListener(this);
            add(ExitB);

            setVisible(true);

        }

        public void actionPerformed(ActionEvent e){
            boolean flag = true;
            if(e.getSource() == loginB){
                try{

                    ResultSet rs2 = getRS("select count(*) from teachers;");
                    rs2.next();
                    int limit = rs2.getInt(1);
                    rs2.close();
                    ResultSet rs = getRS("select * from teachers;");
//


                    String username = text_name.getText();
                    username = username.toLowerCase();
                    String pass = text_passw.getText();
                    pass = pass.toLowerCase();
//               System.out.println(username);
//               System.out.println(pass);


                    while (flag){
                        for (int i=0; i<limit; i++)
                        {
//                            System.out.println(limit);
                            rs.next();
//                            System.out.println(rs.getString(1));
//                            System.out.println(rs.getString(3));
                            if( rs.getString(1).equals(username) && rs.getString(3).equals(pass)){
                                flag = false;
                                JOptionPane.showMessageDialog(this,"Logged in Successfully");
                                setVisible(false);
//                                teacherView obj = new teacherView();
                                new teacherView(username);
                                break;

                            }
                        }
                        if(flag == true){
                            JOptionPane.showMessageDialog(this, "Username or password must be incorrect");
                            text_name.setText("");
                            text_passw.setText("");
//                       setVisible(false);
//                       new main_frame();
                        }
                    }
                }
                catch (Exception ae){
                    ae.printStackTrace();
                }
            }
            else if(e.getSource() == ExitB){
                System.exit(0);
            }
    }



    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        new teacherLogIn();
//        studentLogIn obj = new studentLogIn();

    }
}
