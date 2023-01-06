package com.company;
import javax.swing.*;
import java.sql.*;
import java.util.Scanner;

public class dbCon extends JFrame {
    ResultSet getRS(String Query) throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost:3306/cbtQuiz";
        String root = "root";
        String password = "Kireeti@2000";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url,root,password);

        Statement st = con.createStatement();
//        System.out.println(Query);
        ResultSet rs = st.executeQuery(Query);
        System.out.println("working");
        return (rs);

//        st.close();
//        con.close();
    }

    void addinsert(String usn,String name,String passw,String mail) throws ClassNotFoundException, SQLException {

        String url = "jdbc:mysql://localhost:3306/cbtQuiz";
        String root = "root";
        String password = "Kireeti@2000";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url,root,password);

        PreparedStatement st = con.prepareStatement("INSERT INTO students VALUES(?,?,?,?)");
//        System.out.println(Query);
        st.setString(1,usn);
        st.setString(2,name);
        st.setString(3,passw);
        st.setString(4,mail);
        st.executeUpdate();

        st.close();

        PreparedStatement st1 = con.prepareStatement("INSERT INTO quiz_result(usn,total_score) VALUES(?,?)");
        st1.setString(1,usn);
        st1.setInt(2,0);
        st1.executeUpdate();
        st1.close();

    }

    void delete(String USN) throws ClassNotFoundException, SQLException {

            String url = "jdbc:mysql://localhost:3306/cbtQuiz";
            String root = "root";
            String password = "Kireeti@2000";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,root,password);

        PreparedStatement st = con.prepareStatement("delete from quiz_result where usn=?");
//        System.out.println(Query);
        st.setString(1,USN);
        st.executeUpdate();
        st.close();

            PreparedStatement st1 = con.prepareStatement("delete from students where usn=?");
//        System.out.println(Query);
            st1.setString(1,USN);
            st1.executeUpdate();
            st1.close();

        }

        void addQuestion(String Ques,String opt1,String opt2,String opt3,String opt4,String optcort,String teach)throws ClassNotFoundException, SQLException{
            String url = "jdbc:mysql://localhost:3306/cbtQuiz";
            String root = "root";
            String password = "Kireeti@2000";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,root,password);

            PreparedStatement st = con.prepareStatement("INSERT INTO questions_answers(question,option_1,option_2,option_3,option_4,answer,teacher_id) VALUES(?,?,?,?,?,?,?)");
//        System.out.println(Query);
//            st.setString(1,USN);
            st.setString(1,Ques);
            st.setString(2,opt1);
            st.setString(3,opt2);
            st.setString(4,opt3);
            st.setString(5,opt4);
            st.setString(6,optcort);
            st.setString(7,teach);

            st.executeUpdate();
            st.close();


        }

        void addScore(String USN,int score)throws ClassNotFoundException, SQLException{

            String url = "jdbc:mysql://localhost:3306/cbtQuiz";
            String root = "root";
            String password = "Kireeti@2000";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,root,password);

            PreparedStatement st = con.prepareStatement("update quiz_result set total_score = ? where usn = ?");
//        System.out.println(Query);
            st.setInt(1,score);
            st.setString(2,USN);
            st.executeUpdate();
            st.close();
        }

    public static void main(String[] args)throws Exception {

        new dbCon();
    }
}