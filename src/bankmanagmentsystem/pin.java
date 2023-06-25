
package bankmanagmentsystem;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;

public class pin extends JFrame implements ActionListener{
    
    JLabel text,pintext,repintext;
    JButton change,back;
    JPasswordField pinn,repinn;
    String pinnumber;
    
    pin(String pinnumber){
        
        this.pinnumber = pinnumber;
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        text = new JLabel("CHANGE YOUR PIN");
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setForeground(Color.WHITE);
        text.setBounds(250,280,500,35);
        image.add(text);
        
         pintext = new JLabel("New PIN:");
        pintext.setFont(new Font("System", Font.BOLD, 16));
        pintext.setForeground(Color.WHITE);
         pintext.setBounds(180,390,150,35);
         image.add(pintext);
         
          pinn = new JPasswordField();
         pinn.setFont(new Font("Raleway",Font.BOLD,25));
         pinn.setBounds(350,390,180,25);
         image.add(pinn);
        
        repintext = new JLabel("Re-Enter New PIN:");
        repintext.setFont(new Font("System", Font.BOLD, 16));
        repintext.setForeground(Color.WHITE);
        repintext.setBounds(180,440,200,35);
        image.add(repintext);
        
         repinn = new JPasswordField();
         repinn.setFont(new Font("Raleway",Font.BOLD,25));
         repinn.setBounds(350,440,180,25);
         image.add(repinn);
        
      
        
        
        change = new JButton("CHANGE");
         change.setBounds(390,588,150,35);
         change.addActionListener(this);
         image.add(change);
         
        back = new JButton("BACK"); 
        back.setBounds(390,633,150,35);
        back.addActionListener(this);
        image.add(back);
        
         setSize(900,900);
        setLocation(300,0);
       setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        try{        
            String npin = pinn.getText();
            String rpin = repinn.getText();
            
            
            if(!npin.equals(rpin)){
                JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                return;
            }
            
            if(ae.getSource()==change){
                if (pinn.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Enter New PIN");
                }
                if (repinn.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Re-Enter new PIN");
                }
                
                comn conn = new comn();
                String updateQuery = "UPDATE bank SET pin = '" + rpin + "' WHERE pin = '" + pinnumber + "'";
                String updateLoginQuery = "UPDATE login SET pin = '" + rpin + "' WHERE pin = '" + pinnumber + "'";
                String updateSignupQuery = "UPDATE signup3 SET pin = '" + rpin + "' WHERE pin = '" + pinnumber + "'";

                conn.s.executeUpdate(updateQuery);
                conn.s.executeUpdate(updateLoginQuery);
                conn.s.executeUpdate(updateSignupQuery);

                JOptionPane.showMessageDialog(null, "PIN changed successfully");
                setVisible(false);
                new Transactions(rpin).setVisible(true);
            
            }else if(ae.getSource()==back){
                new Transactions(pinnumber).setVisible(true);
                setVisible(false);
            }
        }catch(Exception e){
           System.out.println(e);
        }
    }

  
    public static void main(String args[]) {
        new pin("").setVisible(true);
    }
}
