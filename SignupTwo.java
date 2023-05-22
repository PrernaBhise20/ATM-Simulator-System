

package atm.simulator.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;


public class SignupTwo extends JFrame implements ActionListener {
  String formno;
    long random;
    JTextField nameTextField,adharTextField,panTextField,religionTextField;//emailTextField,addressTextField,cityTextField,stateTextField,pincodeTextField,occupationTextField;
    JButton next;
    JRadioButton syes,sno,eyes,eno;
  JComboBox c1, c2, c3,c4 ,c5;
    JLabel pincode,religion,additionalDetails,category,income,educational,qualification,occupation,pan,adhar,seniorcitizon,exitaccount ;
    
    
    SignupTwo(String formno){
        this.formno=formno;
        setLayout(null);
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        
//        Random ran=new Random();
//        long random=(Math.abs(ran.nextLong()% 9000L)+1000);
//       
 
        
        additionalDetails = new JLabel("Page 2 - Additional Details");
        additionalDetails.setFont(new Font("Raleway",Font.BOLD,23));
        additionalDetails.setBounds(240,50,400,30);
        add(additionalDetails);
        
        
        religion = new JLabel("Religion:");
        religion.setFont(new Font("Raleway",Font.BOLD,24));
        religion.setBounds(100,90,120,30);
        add(religion);
        
       String valReligion[]={"Hindu","Muslim","Sikh","Christian","Other"};
       JComboBox c1=new JComboBox(valReligion);
       c1.setBounds(300,90,400,30);
       c1.setBackground(Color.WHITE);
       add(c1);
        
//religionTextField =new religionTextField();



        nameTextField =new JTextField();
        nameTextField.setFont(new Font("Raleway",Font.BOLD,18));
        nameTextField.setBounds(300,90,400,30);
        add(nameTextField);
        
        category = new JLabel("Category:");
category.setFont(new Font("Raleway",Font.BOLD,24));
        category.setBounds(100,130,180,30);
        add(category);
        
       
     String valcategory[]={"General","OBC","ST","SC","Other"};
       JComboBox c2=new JComboBox(valcategory);
        c2.setBounds(300,130,400,30);
        c2.setBackground(Color.WHITE);
       add( c2);
   
        income = new JLabel("Income:");
        income.setFont(new Font("Raleway",Font.BOLD,24));
        income.setBounds(100,170,200,33);
        add(income);
        
String incomecategory[]={"Null","<1,50,000","<2,50,000","<5,00,000","Upto 10,00,000"};
      JComboBox c3=new JComboBox(incomecategory);
      c3.setBounds(300,170,400,30);
       c3.setBackground(Color.WHITE);
       add(c3);

        educational = new JLabel("Educational");
        educational.setFont(new Font("Raleway",Font.BOLD,24));
        educational.setBounds(100,210,200,30);
        add(educational);

         
        qualification = new JLabel("Qualification:");
       qualification.setFont(new Font("Raleway",Font.BOLD,24));
       qualification.setBounds(100,235,200,30);
        add(qualification);
        
        String educationalvalues[]={"Non-Graduation","Graduate","Post-Graduate","Doctrate","Other"};
      JComboBox c4 =new JComboBox(educationalvalues);
       c4.setBounds(300,230,400,30);
       c4.setBackground(Color.WHITE);
       add(c4);
       
//        emailTextField =new JTextField();
//        emailTextField.setFont(new Font("Raleway",Font.BOLD,18));
//        emailTextField.setBounds(300,230,400,30);
//        add(emailTextField);
        
        
        occupation = new JLabel("Occupation:");
        occupation.setFont(new Font("Raleway",Font.BOLD,24));
        occupation.setBounds(100,290,200,30);
        add(occupation);
        
        String occupationvalues[]={"Salarised","Self-Employed","Bussiness","Student","Retired","Other"};
        JComboBox c5 =new JComboBox(occupationvalues);
      c5.setBounds(300,290,400,30);
      c5.setBackground(Color.WHITE);
       add(c5);
         
//       occupationTextField =new JTextField();
//       occupationTextField.setFont(new Font("Raleway",Font.BOLD,18));
//        occupationTextField.setBounds(300,230,400,30);
//        add(occupationTextField);
//        
//   
//            
        pan = new JLabel("PAN Number:");
        pan.setFont(new Font("Raleway",Font.BOLD,24));
        pan.setBounds(100,330,200,30);
        add(pan);
          
        panTextField =new JTextField();
        panTextField.setFont(new Font("Raleway",Font.BOLD,18));
       panTextField.setBounds(300,330,400,30);
        add(panTextField);
        
        adhar = new JLabel("Adhar Number");
        adhar.setFont(new Font("Raleway",Font.BOLD,24));
        adhar.setBounds(100,370,200,30);
        add(adhar);
        
         adharTextField =new JTextField();
        adharTextField.setFont(new Font("Raleway",Font.BOLD,18));
        adharTextField.setBounds(300,370,400,30);
        add(adharTextField);
        
        seniorcitizon = new JLabel("Senior Citizon:");
        seniorcitizon.setFont(new Font("Raleway",Font.BOLD,24));
        seniorcitizon.setBounds(100,410,200,30);
        add(seniorcitizon);
        
         syes=new JRadioButton("Yes");
        syes.setBounds(300,410,100,30);
      syes.setBackground(Color.WHITE);
        add(syes);
        
          sno=new JRadioButton("No");
        sno.setBounds(450,410,100,30);
      sno.setBackground(Color.WHITE);
        add(sno);
        
        ButtonGroup smaritalgroup=new ButtonGroup();
        smaritalgroup.add(syes);
            smaritalgroup.add(sno);
            
        
        exitaccount = new JLabel("Existing Account:");
        exitaccount .setFont(new Font("Raleway",Font.BOLD,24));
        exitaccount .setBounds(100,450,200,30);
        add(exitaccount );
        
         eyes=new JRadioButton("Yes");
       eyes.setBounds(300,450,100,30);
     eyes.setBackground(Color.WHITE);
        add(eyes);
        
         eno=new JRadioButton("No");
        eno.setBounds(450,450,100,30);
        eno.setBackground(Color.WHITE);
        add(eno);

 ButtonGroup emaritalgroup=new ButtonGroup();
        emaritalgroup.add(eyes);
            emaritalgroup.add(eno);        

        next=new JButton("Submit");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(620,490,100,30);
       next.addActionListener(this);
        add(next);
        
        getContentPane().setBackground(Color.WHITE);
        setSize(800,800);
        setLocation(350,10);
        setVisible(true);
        
      }
    
    public void actionPerformed(ActionEvent ae){
        String formno=""+random;
        String religion = (String)c1.getSelectedItem(); 
        String category = (String)c2.getSelectedItem();
        String income = (String)c3.getSelectedItem();
        String education = (String)c4.getSelectedItem();
        String occupation = (String)c5.getSelectedItem();
       
      String pan = panTextField.getText();
        String aadhar = adharTextField.getText();
        
        String scitizen = "";
        if(syes.isSelected()){ 
            scitizen = "Yes";
        }
        else if(sno.isSelected()){ 
            scitizen = "No";
        }
           
        String eaccount = "";
        if(eyes.isSelected()){ 
            eaccount = "Yes";
        }else if(eno.isSelected()){ 
            eaccount = "No";
        }
        
        try{
            if(adharTextField.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Fill all the required fields");
            }else{
                Conn c = new Conn();
                String q1 = "insert into signupTwo values('"+formno+"','"+religion+"','"+category+"','"+income+"','"+education+"','"+occupation+"','"+pan+"','"+aadhar+"','"+scitizen+"','"+eaccount+"')";
                c.s.executeUpdate(q1);
                
                setVisible(false);
               new SignupThree(formno).setVisible(true);
              
            }
                
      
            
        }catch(Exception ex){
             ex.printStackTrace();
        }
    
               
    }
    
    
    public static void main(String args[])
    {
        //new SignupTwo();
        new SignupTwo("").setVisible(true);
    }
      
}
