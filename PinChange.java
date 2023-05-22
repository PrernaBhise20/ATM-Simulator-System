
package atm.simulator.system;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PinChange extends JFrame implements ActionListener{
   JButton change,back;
   JPasswordField pin,repin;
    String pinnumber;
    PinChange(String pinnumber){
        setLayout(null);
        this.pinnumber=pinnumber;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,650);
        add(image);
        
         JLabel text=new JLabel("Change Your PIN");
        text.setBounds(260,175,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);
        
        JLabel pintext=new JLabel("New PIN");
        pintext.setBounds(170,230,700,35);
        pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font("System",Font.BOLD,16));
        image.add(pintext);
        
         pin=new JPasswordField();
        pin.setFont(new Font("Raleway",Font.BOLD,22));
        pin.setBounds(240,240,280,23);
        image.add(pin);
        
        JLabel repintext=new JLabel("Re-Enter New PIN");
        repintext.setBounds(155,270,700,35);
        repintext.setForeground(Color.WHITE);
        repintext.setFont(new Font("System",Font.BOLD,16));
        image.add(repintext);
        
         repin=new JPasswordField();
        repin.setFont(new Font("Raleway",Font.BOLD,22));
        repin.setBounds(290,280,230,23);
        image.add(repin);
        
        back=new JButton("Back");
         back.setBounds(155,350,150,30);
         back.addActionListener(this);
        image.add( back);
        
         change=new JButton("Change");
        change.setBounds(365,350,150,30);
         change.addActionListener(this);
        image.add( change);
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==change){
        try{
            String npin=pin.getText();
            String rpin=repin.getText();
            
            if(npin.equals(rpin)){
                JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                return;
            }
            
            if(npin.equals("")){
                JOptionPane.showMessageDialog(null, "Please Enter New PIN");
                return;
            }
            
            if(rpin.equals("")){
                JOptionPane.showMessageDialog(null, "Please Re-Enter New PIN");
                return;
            }
            
            Conn conn=new Conn();
            String query1="update atm set pin='"+rpin+"' where pin ='"+pinnumber+"'";
                 String query2="update login set pin='"+rpin+"' where pin ='"+pinnumber+"'";
             String query3="update signupThree set pin='"+rpin+"' where pin ='"+pinnumber+"'";
        
        conn.s.executeUpdate(query1);
        conn.s.executeUpdate(query2);
        conn.s.executeUpdate(query3);
        
        JOptionPane.showMessageDialog(null, " PIN Changed Successfully");
        
        
        setVisible(false);
        new Transactions(rpin).setVisible(true);
        }catch(Exception e){
            System.out.println(e);
        }
        }else{
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
            
        }
    }
    public static void main(String args[]){
        new PinChange("").setVisible(true);
    }
}
