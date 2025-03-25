
package com.urverse.nubean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import com.urverse.newuser.NewUserDetails;

public class NewUserDao {
    public static Connection getConnection(){
	Connection con=null;
	try{
                Class.forName("oracle.jdbc.driver.OracleDriver");
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","admin");
	}catch(Exception e){System.out.println(e);}
	return con;
    }
    public static int save(NewUserDetails u){
	int status=0; 
	try{
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("insert into NUSER_DETAILS(uname,password) values(?,?)");
		ps.setString(1,u.getuname());
		ps.setString(2,u.getpassword());
		status=ps.executeUpdate();
	}catch(Exception e){System.out.println(e);}
	return status;
}
    
}
