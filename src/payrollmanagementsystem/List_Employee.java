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

public class List_Employee extends JFrame implements ActionListener{
  
    JTable j1;
    JButton b1;
    String h[]={"Emp id","Name","Gender","Contact","Address","Country","Email id","Designation","Education","Experience"};
    String d[][]=new String[20][10];  
    int i=0,j=0;
    
    List_Employee(){
        super("View Employees");
        
        setSize(1000,400);
        setLocation(450,200);

        try{
            String q="select * from addEmployee";
            conn c1=new conn();
            ResultSet rs=c1.s.executeQuery(q);
            while(rs.next()){
                // i = 0 j = 0
                d[i][j++]=rs.getString("id");
                d[i][j++]=rs.getString("nametxtadd");
                d[i][j++]=rs.getString("gendercombobox");
                d[i][j++]=rs.getString("contacttxtadd");
                d[i][j++]=rs.getString("addresstxtadd");
                d[i][j++]=rs.getString("countrybox");
                d[i][j++]=rs.getString("Emailtxtadd");
                d[i][j++]=rs.getString("designationbox");
                d[i][j++]=rs.getString("educationtxtadd");
                d[i][j++]=rs.getString("experiencetxt");
                
                i++;
                j=0;
            }
            j1=new JTable(d,h); 

        }
        catch(Exception e){}
        
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
     
    public static void main(String s[]){
        new List_Employee().setVisible(true);
    }
}
