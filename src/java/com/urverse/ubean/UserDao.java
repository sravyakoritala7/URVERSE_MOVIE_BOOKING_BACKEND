
package com.urverse.ubean;
import com.urverse.user.UserDetails;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDao {

    public static Connection getConnection(){
	Connection con=null;
	try{
                Class.forName("oracle.jdbc.driver.OracleDriver");
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","admin");
	}catch(Exception e){System.out.println(e);}
	return con;
}
 public static int validateUser(UserDetails u){
	int status=0; 
	try{
		Connection con=getConnection();
                if(con==null){
                    System.out.println("Database Connection is not success");
                }
                PreparedStatement ps = con.prepareStatement("SELECT * FROM nuser_details WHERE uname = ? AND password = ?");
                ps.setString(1, u.getuname());
                ps.setString(2, u.getpassword());
                ResultSet rs = ps.executeQuery();
                if(rs.next()){
                    status=1;
                }
	}catch(Exception e){System.out.println(e);}
	return status;
}
    
}

    
