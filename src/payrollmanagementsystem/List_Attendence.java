/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package payrollmanagementsystem;

/**
 *
 * @author nasr_
 */
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;

public class List_Attendence extends JFrame implements ActionListener{
  
    JTable j1;
    JButton b1;
    String h[]={"Emp id","Date Time","Attendence"};
    String d[][]=new String[15][3];  
    int i=0,j=0;
    
    List_Attendence(){
        super("View Employees Attendence");
        setSize(800,300);
        setLocation(450,150);

        try{
            String q="select * from attendence";
            conn c1=new conn();
            ResultSet rs=c1.s.executeQuery(q);
            while(rs.next()){
                d[i][j++]=rs.getString("id");
                d[i][j++]=rs.getString("date_tm");
                d[i][j++]=rs.getString("attendence");
                i++;
                j=0;
            }
        
            j1=new JTable(d,h);

        }catch(Exception e){}
        
        b1=new JButton("Print");
        add(b1,"South");
        JScrollPane s1=new JScrollPane(j1);
        add(s1);
        
        b1.addActionListener(this);
    
    }
    public void actionPerformed(ActionEvent ae){
        try{
            j1.print();
        }catch(Exception e){}
    }
    
    public static void main(String[] args){
        new List_Attendence().setVisible(true);
    }
}

