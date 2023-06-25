
package bankmanagmentsystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;

public class SignUp2 extends JFrame implements ActionListener {

    
   
    JTextField pan,aadhar;
    JButton next;
    JRadioButton syes,sno,eyes,eno;
    String formno;
    
    JComboBox religion, category,occupation,education,income;
    SignUp2(String formno){
        this.formno = formno;
        setLayout(null);
        
        setTitle("NEW APPLICATION FORM - PAGE2 ");
        
        
        
        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionalDetails.setBounds(290,80,400,30);
        add(additionalDetails);
        
        JLabel name = new JLabel("Religion:");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100,140,100,30);
        add(name);
        
        String valReligion[] = {"Hindu","Muslim","Christian","Sikh","Other"};
        religion = new JComboBox(valReligion);
        religion.setBounds(300,140,400,30);
        religion.setBackground(Color.WHITE);
        add(religion);
        
        
        
        JLabel fname = new JLabel("Category:");
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        fname.setBounds(100,190,200,30);
        add(fname);
        
        String valcategory[] = {"General","OBC","SC","ST","Other"};
         category = new JComboBox(valcategory);
        category.setBackground(Color.white);
        category.setBounds(300,190,400,30);
        add(category);
        
        
        JLabel dob = new JLabel("Income:");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100,240,200,30);
        add(dob);
        
        String incomecategory[] = {"Null"," < 1,50,000"," < 2,50,000","<5,00,000","upto 10,00,000"};
         income = new JComboBox(incomecategory);
        income.setBackground(Color.white);
        income.setBounds(300,240,400,30);
        add(income);
        
        
        
        
        JLabel gender = new JLabel("Education:");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(100,290,200,30);
        add(gender);
        
         
        
        
        JLabel email = new JLabel("Qualification:");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(100,315,200,30);
        add(email);
        
        String educationValues[] = {"Non-Graduation"," Graduate"," Post-Graduation","Doctrate","Other"};
        education = new JComboBox(educationValues);
        education.setBackground(Color.white);
        education.setBounds(300,315,400,30);
        add(education);
        
       
        
        JLabel marital = new JLabel("Occupation:");
        marital.setFont(new Font("Raleway", Font.BOLD, 20));
        marital.setBounds(100,390,200,30);
        add(marital);
        
        String occupationValues[] = {"Salaried"," Self-Employed"," Business","Student","Retired","Others"};
         occupation = new JComboBox(occupationValues);
        occupation.setBackground(Color.white);
        occupation.setBounds(300,390,400,30);
        add(occupation);
        
        
        JLabel pannum = new JLabel("Pan Number:");
        pannum.setFont(new Font("Raleway", Font.BOLD, 20));
        pannum.setBounds(100,440,200,30);
        add(pannum);
        
        pan = new JTextField();
        pan.setFont(new Font("Raleway",Font.BOLD,14));
        pan.setBounds(300,440,400,30);
        add(pan);
        
        JLabel adharno = new JLabel("Adhar No:");
        adharno.setFont(new Font("Raleway", Font.BOLD, 20));
        adharno.setBounds(100,490,200,30);
        add(adharno);
        
        aadhar = new JTextField();
        aadhar.setFont(new Font("Raleway",Font.BOLD,14));
        aadhar.setBounds(300,490,400,30);
        add(aadhar);
        
        JLabel citizen = new JLabel("Senior Citizen:");
        citizen.setFont(new Font("Raleway", Font.BOLD, 20));
        citizen.setBounds(100,540,200,30);
        add(citizen);
        
        syes = new JRadioButton("yes");
        syes.setBounds(330,540,100,30);
        syes.setBackground(Color.WHITE);
        add(syes);
        
        sno = new JRadioButton("No");
        sno.setBounds(450,540,100,30);
        sno.setBackground(Color.WHITE);
        add(sno);
        
        ButtonGroup scitizengroup = new ButtonGroup();
        scitizengroup.add(syes);
        scitizengroup.add(sno);
         
        
        JLabel account = new JLabel("Existing account:");
        account.setFont(new Font("Raleway", Font.BOLD, 20));
        account.setBounds(100,590,200,30);
        add(account);
        
        eyes = new JRadioButton("yes");
        eyes.setBounds(330,590,100,30);
        eyes.setBackground(Color.WHITE);
        add(eyes);
        
        eno = new JRadioButton("No");
        eno.setBounds(450,590,100,30);
        eno.setBackground(Color.WHITE);
        add(eno);
        
        ButtonGroup ecitizengroup = new ButtonGroup();
        ecitizengroup.add(eyes);
        ecitizengroup.add(eno);
        
        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(620,660,80,30);
        next.addActionListener(this);
        add(next);
        
        getContentPane().setBackground(Color.WHITE);
        
        
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae) {
    
    String sreligion = (String)religion.getSelectedItem();
    String scategory = (String)category.getSelectedItem();
    String sincome = (String) income.getSelectedItem();
    String seducation = (String)education.getSelectedItem();
    String soccupation = (String)occupation.getSelectedItem();
    
    String seniorcitizen = null;
if (syes.isSelected()) {
    seniorcitizen = "Yes";
} else if (sno.isSelected()) {
    seniorcitizen = "No";
}

    String existingaccount = null;
    if (eyes.isSelected()) {
        existingaccount = "Yes";
    } else if (eno.isSelected()) {
        existingaccount = "No";
    } 

    String span = pan.getText();
    String saadhar = aadhar.getText();
    

    try {
            comn c = new comn();
            String query = "insert into signup2 values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+span+"','"+saadhar+"','"+seniorcitizen+"','"+existingaccount+"')";
            c.s.executeUpdate(query);
            
            //signup3 object
            setVisible(false);
            new SignUp3(formno).setVisible(true);
    } catch (Exception e) {
        System.out.println(e);
    }
}


    
    public static void main(String args[]) {
        new SignUp2("");
    }
}
