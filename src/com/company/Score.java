package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;


public class Score extends dbCon{
    String username;
    int stdscore;
        Score(String username, int score){
            this.username = username;
            stdscore = score;
            setBounds(0, 0, 1375, 768);
            getContentPane().setBackground(Color.WHITE);
            setLayout(null);

            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("com/company/icons/score.png"));
            Image i2 = i1.getImage().getScaledInstance(300, 250, Image.SCALE_DEFAULT);
            ImageIcon i3 = new ImageIcon(i2);
            JLabel l1 = new JLabel(i3);
            l1.setBounds(450, 150, 300, 250);
            add(l1);

            JLabel l2 = new JLabel("Thankyou, " + username + " For Attending DSU Quiz");
            l2.setBounds(400, 30, 700, 30);
            l2.setFont(new Font("RALEWAY", Font.PLAIN, 26));
            add(l2);

            JLabel l3 = new JLabel("Your Score is " + score);
            l3.setBounds(500, 500, 300, 30);
            l3.setFont(new Font("Jokerman", Font.PLAIN, 26));
            l3.setForeground(new Color(199, 21, 133));
            add(l3);

            try{
                System.out.println(username +""+stdscore);
                addScore(username, stdscore);
            }
            catch (ClassNotFoundException | SQLException ex) {
                JOptionPane.showMessageDialog(this, ex);
                ex.printStackTrace();
            }


        }

        public static void main(String[] args){

            new Score("", 0).setVisible(true);
        }
    }
