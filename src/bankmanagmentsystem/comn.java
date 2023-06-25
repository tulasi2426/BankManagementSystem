
package bankmanagmentsystem;

import java.sql.*;

public class comn {
    
    Connection c;
    Statement s;

    public comn() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","123456");
            s = c.createStatement();
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
}
