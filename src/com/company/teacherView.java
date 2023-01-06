package com.company;

import javax.swing.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class teacherView extends dbCon implements ActionListener{

    String teacherName;
    JFrame frame,f1,f2,f3,f4;
    JLabel aStuUsn,aStuName,aStuPass,aStuEmail,dStuUsn,qQues,qOpt1,qOpt2,qOpt3,qOpt4,qCOpt;
    JTextField aTextUsn,aTextName,aTextPass,aTextEmail,dTextUsn,qQuesText,qTextOpt1,qTextOpt2,qTextOpt3,qTextOpt4,qTextCOpt;
    JButton aAdd,view,delete,find,qAdd,abutton,dbutton,qbutton,viewButton,aback,dback,qback,logout;


    teacherView(String teacher) {

        teacherName = teacher;
//        System.out.println(teacherName+"  here here this one");


        frame = new JFrame();
        frame.setTitle("Teacher View");


        frame.setBounds(0, 0, 1375, 768);
        frame.setLayout(null);


        frame.setVisible(true);

        abutton = new JButton("Add Student");
        abutton.setBounds(400, 100, 150, 40);
        abutton.addActionListener(this);
        frame.add(abutton);

        dbutton = new JButton("Delete Student");
        dbutton.setBounds(700, 100, 150, 40);
        dbutton.addActionListener(this);
        frame.add(dbutton);

        qbutton = new JButton("Add Question");
        qbutton.setBounds(400, 300, 150, 40);
        qbutton.addActionListener(this);
        frame.add(qbutton);

        viewButton = new JButton("View Student");
        viewButton.setBounds(700, 300, 150, 40);
        viewButton.addActionListener(this);
        frame.add(viewButton);

        logout = new JButton("LogOut");
        logout.setBounds(1250, 10, 100, 20);
        logout.addActionListener(this);
        frame.add(logout);


    }

    void addStudent(){

        f1 = new JFrame();
        f1.setBounds(0,0,1375,768);
        f1.setLayout(null);
        f1.setVisible(true);

        frame.setVisible(false);


        aStuUsn = new JLabel("USN:");
        aStuUsn.setBounds(500, 100, 100, 40);
        aStuUsn.setFont(new Font("Mongolian Baiti", Font.BOLD, 20));
        f1.add(aStuUsn);

        aTextUsn = new JTextField();
        aTextUsn.setBounds(640, 105, 200, 25);
        f1.add(aTextUsn);

        aStuName = new JLabel("NAME:");
        aStuName.setBounds(500, 140, 200, 40);
        aStuName.setFont(new Font("Mongolian Baiti", Font.BOLD, 20));
        f1.add(aStuName);

        aTextName = new JTextField();
        aTextName.setBounds(640, 145, 200, 25);
        f1.add(aTextName);

        aStuPass = new JLabel("Set Password:");
        aStuPass.setBounds(500, 180, 200, 40);
        aStuPass.setFont(new Font("Mongolian Baiti", Font.BOLD, 20));
        f1.add(aStuPass);

        aTextPass = new JTextField();
        aTextPass.setBounds(640, 185, 200, 25);
        f1.add(aTextPass);

        aStuEmail = new JLabel("Email:");
        aStuEmail.setBounds(500, 220, 200, 40);
        aStuEmail.setFont(new Font("Mongolian Baiti", Font.BOLD, 20));
        f1.add(aStuEmail);

        aTextEmail = new JTextField();
        aTextEmail.setBounds(640, 225, 200, 25);
        f1.add(aTextEmail);

        aAdd = new JButton("ADD");
        aAdd.setBounds(500, 300, 150, 40);
        aAdd.addActionListener(this);
        f1.add(aAdd);

        aback = new JButton("BACK");
        aback.setBounds(700, 300, 150, 40);
        aback.addActionListener(this);
        f1.add(aback);



    }

    void delete(){


        f2 = new JFrame();
        f2.setBounds(0,0,1375,768);
        f2.setLayout(null);
        f2.setVisible(true);

        frame.setVisible(false);



        dStuUsn = new JLabel("USN:");
        dStuUsn.setBounds(500, 100, 100, 40);
        dStuUsn.setFont(new Font("Mongolian Baiti", Font.BOLD, 20));
        f2.add(dStuUsn);

        dTextUsn = new JTextField();
        dTextUsn.setBounds(640, 105, 200, 25);
        f2.add(dTextUsn);

        delete = new JButton("DELETE");
        delete.setBounds(500, 300, 150, 40);
        delete.addActionListener(this);
        f2.add(delete);

        dback = new JButton("BACK");
        dback.setBounds(700, 300, 150, 40);
        dback.addActionListener(this);
        f2.add(dback);

    }

    void addQues(){


        f3 = new JFrame();
        f3.setBounds(0,0,1375,768);
        f3.setLayout(null);
        f3.setVisible(true);

        frame.setVisible(false);

        qQues = new JLabel("Question:");
        qQues.setBounds(500, 100, 100, 40);
        qQues.setFont(new Font("Mongolian Baiti", Font.BOLD, 20));
        f3.add(qQues);

        qQuesText = new JTextField();
        qQuesText.setBounds(640, 105, 400, 25);
        f3.add(qQuesText);

        qOpt1 = new JLabel("Option 1:");
        qOpt1.setBounds(500, 140, 200, 40);
        qOpt1.setFont(new Font("Mongolian Baiti", Font.BOLD, 20));
        f3.add(qOpt1);

        qTextOpt1= new JTextField();
        qTextOpt1.setBounds(640, 145, 200, 25);
        f3.add(qTextOpt1);

        qOpt2 = new JLabel("Option 2:");
        qOpt2.setBounds(500, 180, 200, 40);
        qOpt2.setFont(new Font("Mongolian Baiti", Font.BOLD, 20));
        f3.add(qOpt2);

        qTextOpt2 = new JTextField();
        qTextOpt2.setBounds(640, 185, 200, 25);
        f3.add(qTextOpt2);

        qOpt3 = new JLabel("Option 3:");
        qOpt3.setBounds(500, 220, 200, 40);
        qOpt3.setFont(new Font("Mongolian Baiti", Font.BOLD, 20));
        f3.add(qOpt3);

        qTextOpt3 = new JTextField();
        qTextOpt3.setBounds(640, 225, 200, 25);
        f3.add(qTextOpt3);

        qOpt4 = new JLabel("Option 4:");
        qOpt4.setBounds(500, 260, 200, 40);
        qOpt4.setFont(new Font("Mongolian Baiti", Font.BOLD, 20));
        f3.add(qOpt4);

        qTextOpt4 = new JTextField();
        qTextOpt4.setBounds(640, 265, 200, 25);
        f3.add(qTextOpt4);

        qCOpt = new JLabel("Correct Option:");
        qCOpt.setBounds(500, 300, 200, 40);
        qCOpt.setFont(new Font("Mongolian Baiti", Font.BOLD, 20));
        f3.add(qCOpt);

        qTextCOpt = new JTextField();
        qTextCOpt.setBounds(640, 305, 200, 25);
        f3.add(qTextCOpt);

        qAdd = new JButton("Add Question");
        qAdd.setBounds(500, 400, 150, 40);
        qAdd.addActionListener(this);
        f3.add(qAdd);

        qback = new JButton("BACK");
        qback.setBounds(700, 400, 150, 40);
        qback.addActionListener(this);
        f3.add(qback);


    }

    void viewStudents(){


        try{
            ResultSet rs2 = getRS("select count(usn) from students;");
            rs2.next();
            int limit = rs2.getInt(1);
            rs2.close();
            ResultSet rs = getRS("select * from students;");

            String[][] data = new String[limit][4];


            for(int i=0; i<limit ; i++)
            {
                rs.next();
                for(int j=0;j<4;j++)
                {

                    data[i][j] = rs.getString((j+1));

                }
            }
            rs.close();

            f4=new JFrame();

            String[] column ={"USN","NAME","PASSWORD","EMAIL"};
            JTable jt=new JTable(data,column);
            jt.setBounds(30,40,200,300);
            JScrollPane sp=new JScrollPane(jt);
            f4.add(sp);

            f4.setBounds(0,0,1375,768);


//            f.setDefaultCloseOperation(EXIT_ON_CLOSE);
            f4.setVisible(true);

        }
        catch (Exception e){
            e.printStackTrace();
        }

        }





    public void actionPerformed(ActionEvent e){
        if(e.getSource() == abutton){
            addStudent();
        }

        else if (e.getSource() == dbutton){

            delete();


        }
        else if(e.getSource() == qbutton){

            addQues();
        }
        else if(e.getSource() == viewButton){

            viewStudents();
        }
        else if(e.getSource() == aback){
            new teacherView("");
            f1.setVisible(false);
        }
        else if(e.getSource() == dback){
            new teacherView("");
            f2.setVisible(false);
        }
        else if(e.getSource() == qback){
            new teacherView("");
            f3.setVisible(false);
        }

//        else if(e.getSource() == i1){
//            frame.setVisible(false);
//            new teacherLogIn();
//        }
        else if(e.getSource() == abutton){
//            frame.setVisible(false);
            addStudent();
        }
        else if(e.getSource() == aAdd){
            if(Objects.equals(aTextName.getText(), "") && Objects.equals(aTextUsn.getText(), "") && Objects.equals(aTextName.getText(), "") && Objects.equals(aTextPass.getText(), "") && Objects.equals(aTextEmail.getText(), "")) {
                JOptionPane.showMessageDialog(this, "Text fields cannot be empty");
            }
            else{
                try {
                    addinsert(aTextUsn.getText(),aTextName.getText(),aTextPass.getText(),aTextEmail.getText());
                    JOptionPane.showMessageDialog(this, "Successfully Added");
                } catch (ClassNotFoundException | SQLException ex) {
                    JOptionPane.showMessageDialog(this,ex);
                    ex.printStackTrace();
                }
            }
        }
        else if(e.getSource() == delete){
            if(Objects.equals(dTextUsn.getText(),"")){

                JOptionPane.showMessageDialog(this, "USN could not be Empty");
            }
            else{

                try {
                    String temp = dTextUsn.getText();
                    delete(temp.toLowerCase());
                    JOptionPane.showMessageDialog(this, "Deleted Successfully");
                } catch (ClassNotFoundException | SQLException ex) {
                    JOptionPane.showMessageDialog(this, ex);
                    ex.printStackTrace();
                }

            }
        }

        else if(e.getSource() == qAdd){

            if(Objects.equals(qQuesText.getText(), "") && Objects.equals(qTextOpt1.getText(), "") && Objects.equals(qTextOpt2.getText(), "") && Objects.equals(qTextOpt3.getText(), "") && Objects.equals(qTextOpt4.getText(), "") && Objects.equals(qTextCOpt.getText(), "")){
                JOptionPane.showMessageDialog(this, "Text fields cannot be empty");
            }
            else{
                try {
                    addQuestion(qQuesText.getText(),qTextOpt1.getText(),qTextOpt2.getText(),qTextOpt3.getText(),qTextOpt4.getText(),qTextCOpt.getText(),teacherName);
                    JOptionPane.showMessageDialog(this, "Question added Successfully");
                } catch (ClassNotFoundException | SQLException ex) {
                    JOptionPane.showMessageDialog(this, ex);
                }
            }

        }
        else if(e.getSource() == logout){
            JOptionPane.showMessageDialog(this, "Logged out Successfully");
            new teacherLogIn();
            frame.setVisible(false);
        }

    }

    public static void main(String[] args)
    {

        new teacherView("");
//              obj.addStudent();
//              obj.delete();
//              obj.addQues();
//              obj.viewStudents();

    }
}
