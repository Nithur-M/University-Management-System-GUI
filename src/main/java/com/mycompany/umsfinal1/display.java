/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.umsfinal1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;
import javax.swing.*;
/**
 *
 * @author Nithur
 */
public class display {
    String username;
    String selectedRole;
    Connection conn=null;
    PreparedStatement pst=null;
    ResultSet rs=null;
    
    
    public display(String s,String selectedRole){
        this.username=s;
        this.selectedRole=selectedRole;
        //Welcome w=new Welcome();
        conn=mysqlConnect.ConnectDB();
        if(selectedRole.equals("Student"))
        {
        try {
            Statement stat = conn.createStatement();
        String sql = "select name,username,age from student where username ='"+s+"'";
        //pst=conn.prepareStatement(sql);
        rs = stat.executeQuery(sql);
        
    if(rs.next()) { 
        String name = rs.getString("name");
        Welcome.name.setText(name);
        String username = rs.getString("username");
        Welcome.username.setText(username);
        String age = rs.getString("age");
        Welcome.age.setText(age);
    }
    } catch (SQLException e ) {
    JOptionPane.showMessageDialog(null, e);

}
        }
        else
        {
            try {
            Statement stat = conn.createStatement();
        String sql = "select name,username,age from lecturer where username ='"+s+"'";
        //pst=conn.prepareStatement(sql);
        rs = stat.executeQuery(sql);
        
    if(rs.next()) { 
        
        String name = rs.getString("name");
        WelcomeL.name.setText(name);
        String username = rs.getString("username");
        WelcomeL.username.setText(username);
        String age = rs.getString("age");
        WelcomeL.age.setText(age);
    }
    } catch (SQLException e ) {
    JOptionPane.showMessageDialog(null, e);

}
        }
        }
}
