package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class start_quiz extends dbCon implements ActionListener{
        JButton next, submit;
        public static int total = 0;
        public static int count = 0;
        public static int timer = 15;
        public static int ans_given = 0;
        public static int score = 0;
        JLabel qno, question;
        String[][] q = new String[10][7];
        String[][] pa = new String[10][1];

        JRadioButton opt1, opt2, opt3, opt4;
        ButtonGroup options;

        String username;
        start_quiz(String username){
//            System.out.println(username+"in start_quiz");
            this.username = username;
            setBounds(0, 0, 1375, 768);
            getContentPane().setBackground(Color.WHITE);
            setLayout(null);

            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("com/company/icons/quiz.jpg"));
            JLabel l1 = new JLabel(i1);
            l1.setBounds(0, 0, 1440, 340);
            add(l1);

            qno = new JLabel("");
            qno.setFont(new Font("Tahoma", Font.PLAIN, 24));
            qno.setBounds(100, 350, 50, 30);
            add(qno);

            question = new JLabel("");
            question.setFont(new Font("Tahoma", Font.PLAIN, 24));
            question.setBounds(150, 350, 900, 30);
            add(question);


            try {

                ResultSet rs1 = getRS("select count(question) from questions_answers");
                rs1.next();
                int total = rs1.getInt(1);
                rs1.close();
                ResultSet rs2 = getRS("select * from questions_answers;");
//

                for (int i = 0; i < total; i++) {
                    rs2.next();
                    for (int j = 0; j <= 6; j++) {
                        q[i][j] = rs2.getString((j + 1));
//                        System.out.println(rs2.getString((j + 1)));
                    }
                }
            }
            catch (Exception ae){
                ae.printStackTrace();
            }

            opt1 = new JRadioButton("");
            opt1.setBounds(170, 420, 700, 30);
            opt1.setFont(new Font("Dialog", Font.PLAIN, 20));
            opt1.setBackground(Color.WHITE);
            add(opt1);

            opt2 = new JRadioButton("");
            opt2.setBounds(170, 460, 700, 30);
            opt2.setFont(new Font("Dialog", Font.PLAIN, 20));
            opt2.setBackground(Color.WHITE);
            add(opt2);

            opt3 = new JRadioButton("");
            opt3.setBounds(170, 500, 700, 30);
            opt3.setFont(new Font("Dialog", Font.PLAIN, 20));
            opt3.setBackground(Color.WHITE);
            add(opt3);

            opt4 = new JRadioButton("");
            opt4.setBounds(170, 540, 700, 30);
            opt4.setFont(new Font("Dialog", Font.PLAIN, 20));
            opt4.setBackground(Color.WHITE);
            add(opt4);

            options = new ButtonGroup();
            options.add(opt1);
            options.add(opt2);
            options.add(opt3);
            options.add(opt4);

            next = new JButton("Next");
            next.setFont(new Font("Tahoma", Font.PLAIN, 22));
            next.setBackground(new Color(30, 144, 255));
            next.setForeground(Color.WHITE);
            next.addActionListener(this);
            next.setBounds(1100, 450, 200, 40);
            add(next);


            submit = new JButton("Submit");
            submit.setFont(new Font("Tahoma", Font.PLAIN, 22));
            submit.setEnabled(false);
            submit.setBackground(new Color(30, 144, 255));
            submit.setForeground(Color.WHITE);
            submit.addActionListener(this);
            submit.setBounds(1100, 610, 200, 40);
            add(submit);

            start(0);

        }

        public void actionPerformed(ActionEvent ae){
            if(ae.getSource() == next){
                repaint();
                opt1.setEnabled(true);
                opt2.setEnabled(true);
                opt3.setEnabled(true);
                opt4.setEnabled(true);

                ans_given = 1;
                if(options.getSelection() == null){
                    pa[count][0] = "";
                }else {
                    pa[count][0] = options.getSelection().getActionCommand();
//                    System.out.println(pa[count][0]);
                }

                if(count == 8){
                    next.setEnabled(false);
                    submit.setEnabled(true);
                }

                count++;
                start(count);
            }
            else if(ae.getSource() == submit){
                ans_given = 1;
                if(options.getSelection() == null){
                    pa[count][0] = "";
                }else {
                    pa[count][0] = options.getSelection().getActionCommand();
                }

                for(int i =0 ; i < pa.length ; i++){
                    if(pa[i][0].equals(q[i][6])){
                        score+=10;
//                        System.out.println(score);
                    }
                }
                this.setVisible(false);
                new Score(username, score).setVisible(true);
            }

        }

        public void paint(Graphics g){
            super.paint(g);
            String time = "Time Left - " + timer + " seconds"; // 15
            g.setColor(Color.RED);
            g.setFont(new Font("Tahoma", Font.BOLD, 25));

            if(timer > 0) {
                g.drawString(time, 1100, 400);
            }else {
                g.drawString("Times Up!!", 1100, 400);
            }

            timer--; // 14

            try{
                Thread.sleep(1000);
                repaint();
            }catch(Exception e){
                e.printStackTrace();
            }

            if(ans_given == 1){
                ans_given = 0;
                timer = 15;
            }else if(timer < 0){
                timer = 15;
                opt1.setEnabled(true);
                opt2.setEnabled(true);
                opt3.setEnabled(true);
                opt4.setEnabled(true);

                if(count == 8){
                    next.setEnabled(false);
                    submit.setEnabled(true);
                }
                if(count == 9){
                    if(options.getSelection() == null){
                        pa[count][0] = "";
                    }else {
                        pa[count][0] = options.getSelection().getActionCommand();
                    }

                    for(int i =0 ; i < pa.length ; i++){
                        if(pa[i][0].equals(q[i][6])){
                            score+=10;
                        }
                    }
                    this.setVisible(false);
                    new Score(username, score).setVisible(true);
                }else{
                    if(options.getSelection() == null){
                        pa[count][0] = "";
                    }else {
                        pa[count][0] = options.getSelection().getActionCommand();
                    }
                    count++;
                    start(count);
                }
            }
        }

        public void start(int count){
            qno.setText("" + q[count][0] + ". ");
            question.setText(q[count][1]);
            opt1.setLabel(q[count][2]);
            opt1.setActionCommand(q[count][2]);
            opt2.setLabel(q[count][3]);
            opt2.setActionCommand(q[count][3]);
            opt3.setLabel(q[count][4]);
            opt3.setActionCommand(q[count][4]);
            opt4.setLabel(q[count][5]);
            opt4.setActionCommand(q[count][5]);
            options.clearSelection();
        }

        public static void main(String[] args){
            new start_quiz("").setVisible(true);

        }
    }