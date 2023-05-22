
package atm.simulator.system;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;
public class FastCash extends JFrame implements ActionListener {
    JButton b1,b2,b3,b4,b5,b6,exit,amount;
   String pinnumber;
    FastCash(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,650);
        add(image);
        
        JLabel text=new JLabel("Select Withdrawl Amount");
        text.setBounds(230,175,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);
        
       b1=new JButton("RS.100");
         b1.setBounds(170,250,150,30);
         b1.addActionListener(this);
        image.add( b1);
        
        b2=new JButton("RS.500");
         b2.setBounds(335,250,150,30);
         b2.addActionListener(this);
        image.add( b2);
        
        b3=new JButton("RS.1000");
        b3.setBounds(170,300,150,30);
        b3.addActionListener(this);
        image.add(b3);
        
        b4=new JButton("RS.2000");
       b4.setBounds(335,300,150,30);
        b4.addActionListener(this);
        image.add(b4);
        
        b5=new JButton("RS.5000");
         b5.setBounds(170,350,150,30);
         b5.addActionListener(this);
        image.add( b5);
        
        b6=new JButton("RS.10000");
         b6.setBounds(335,350,150,30);
      b6.addActionListener(this);
        image.add(b6);
        
         exit=new JButton("Back");
        exit.setBounds(250,390,150,30);
       exit.addActionListener(this);
        image.add(exit);
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==exit){
           setVisible(false);
           new Transactions(pinnumber).setVisible(true);
        }else {
            String b1=((JButton)ae.getSource()).getText().substring(3);
            Conn c=new Conn();
            try{
                ResultSet rs=c.s.executeQuery("select *from atm where pin='"+pinnumber+"'");
                int balance=0;
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance+=Integer.parseInt(rs.getString("amount"));
                    }else{
                        balance-=Integer.parseInt(rs.getString("amount"));
                    }
                }
                   if(ae.getSource()!=exit && balance<Integer.parseInt(b1)){
                       JOptionPane.showMessageDialog(null,"Insufficient Balance");
                   return;
                   }     
                Date date=new Date();
             
                String query="insert into atm values('"+pinnumber+"','"+date+"','"+b2+"','"+b1+"')";
                c.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"Rs"+b1+"Debited Successfully");
            
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
            
            }catch(Exception e){
                System.out.println(e);
            }
        }
    }
    public static void main(String args[])
    {
        new FastCash("");
    }
}
