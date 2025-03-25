package com.urverse.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.urverse.booking.BookingDetails;

public class TicketDao {
public static Connection getConnection(){
	Connection con=null;
	try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","admin");
	}catch(Exception e){System.out.println(e);}
	return con;
}
public static int sample(BookingDetails u) {
        int status = 0;
        ResultSet rs = null;
        String[] astringArray = u.getaseatsno();
        String[] bstringArray = u.getbseatsno();
        String[] cstringArray = u.getcseatsno();
        int acount = 0, bcount = 0, ccount = 0, id = 0;
        int atotal = 0, btotal = 0, ctotal = 0;
        int no1 = 0, no2 = 0, no3 = 0; // Initialize lengths to 0
        int aprice=0,bprice=0,cprice=0;
        int n = (astringArray != null ? astringArray.length : 0) + (bstringArray != null ? bstringArray.length : 0) + (cstringArray != null ? cstringArray.length : 0);
        int total=0;
        String[] evearray = new String[n];
        String arrayAsString = "";
        try {
            Connection con = getConnection();

            if (astringArray != null) {
                no1 = astringArray.length;
            }
            if (bstringArray != null) {
                no2 = bstringArray.length;
            }
            if (cstringArray != null) {
                no3 = cstringArray.length;
            }
            PreparedStatement ps3 = con.prepareStatement("SELECT s.A_CLASS, s.B_CLASS, s.C_CLASS,s.A_CLASS_COST,s.B_CLASS_COST,s.C_CLASS_COST ,s.MOVIEID FROM SLAVE1 s JOIN MASTER1 m ON s.MOVIEID = m.MOVIEID WHERE m.MOVIE_NAME = ? AND m.THEATRE_NAME = ? AND m.TIMINGS=?");
            ps3.setString(1, u.getmovies());
            ps3.setString(2, u.gettheatres());
            ps3.setString(3, u.gettimings());
            ResultSet rs2 = ps3.executeQuery();
            if (rs2.next()) {
                acount = rs2.getInt("A_CLASS");
                bcount = rs2.getInt("B_CLASS");
                ccount = rs2.getInt("C_CLASS");
                aprice=rs2.getInt("A_CLASS_COST");
                bprice=rs2.getInt("B_CLASS_COST");
                cprice=rs2.getInt("C_CLASS_COST");
                id = rs2.getInt("MOVIEID");
            }
            if (no1 > 0) {
                atotal = acount - no1;
            } else {
                atotal = acount;
            }
            if (no2 > 0) {
                btotal = bcount - no2;
            } else {
                btotal = bcount;
            }
            if (no3 > 0) {
                ctotal = ccount - no3;
            } else {
                ctotal = ccount;
            }
            System.out.println(""+atotal);
             System.out.println(""+aprice);
            total=no1*aprice+no2*bprice+no3*cprice;
            System.out.println(""+atotal);
            PreparedStatement ps1 = con.prepareStatement("UPDATE SLAVE1 SET A_CLASS = ?,B_CLASS=?,C_CLASS=? WHERE MOVIEID = ?");
            ps1.setInt(1, atotal);
            ps1.setInt(2, btotal);
            ps1.setInt(3, ctotal);
            ps1.setInt(4, id);
            status = ps1.executeUpdate();
            if (n == 0) {
                status = 0;
            }
            if (status == 1) {
                saveintable(u, total);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }
public static String getmydetails(BookingDetails u) {
        String[] astringArray = u.getaseatsno();
        String[] bstringArray = u.getbseatsno();
        String[] cstringArray = u.getcseatsno();
        StringBuilder sb = new StringBuilder();
        int n = (astringArray != null ? astringArray.length : 0) + (bstringArray != null ? bstringArray.length : 0) + (cstringArray != null ? cstringArray.length : 0);
        String[] evearray = new String[n];
        int index = 0;
        if (astringArray != null) {
            for (int i = 0; i < astringArray.length; i++) {
                evearray[index++] = astringArray[i];
            }
        }
        if (bstringArray != null) {
            for (int i = 0; i < bstringArray.length; i++) {
                evearray[index++] = bstringArray[i];
            }
        }
        if (cstringArray != null) {
            for (int i = 0; i < cstringArray.length; i++) {
                evearray[index++] = cstringArray[i];
            }
        }
        for (int i = 0; i < evearray.length; i++) {
            sb.append(evearray[i]);
            if (i != evearray.length - 1) {
                sb.append(", "); // Add comma if it's not the last element
            }
        }
        return sb.toString();
    }

public static List<BookingDetails> getAllRecords(BookingDetails u1){
	List<BookingDetails> list=new ArrayList<BookingDetails>();
	int user1=saverecords(u1);
        System.out.println(""+user1);
	try{
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("select * from book_details where id=?");
                 ps.setInt(1,user1);
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			BookingDetails u=new BookingDetails();
			 u.setmovies(rs.getString("moviename"));
                         u.settheatres(rs.getString("theatrename"));
                         u.settimings(rs.getString("timings"));
                         u.setseatsno(rs.getString("seats_booked"));
                         u.setprice(rs.getInt("total_price"));
                         u.setimage(rs.getString("url"));
                          list.add(u);
                            System.out.println("Items");
                            list.forEach(System.out::println);

		}
                System.out.println("Data:"+list);
	}catch(Exception e){System.out.println(e);}
	return list;
}
public static List<BookingDetails> getAllRecords1(BookingDetails u1){
	List<BookingDetails> list=new ArrayList<BookingDetails>();
	int user1=saverecords(u1);
        System.out.println(""+user1);
	try{
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("select * from book_details");
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			BookingDetails u=new BookingDetails();
                        u.setid(rs.getInt("id"));
			 u.setmovies(rs.getString("moviename"));
                         u.settheatres(rs.getString("theatrename"));
                         u.settimings(rs.getString("timings"));
                         u.setseatsno(rs.getString("seats_booked"));
                         u.setprice(rs.getInt("total_price"));
                         u.setimage(rs.getString("url"));
                          list.add(u);
                            System.out.println("Items");
                            list.forEach(System.out::println);

		}
                System.out.println("Data:"+list);
	}catch(Exception e){System.out.println(e);}
	return list;
}


public static int saverecords(BookingDetails u) {
        int lastBookingId, bookid = 0;
        int rowsAffected = 0;
        try {
            Connection con = getConnection();
            String ss = getmydetails(u);
            String movies = u.getmovies();
                    PreparedStatement psGetCustomerId = con.prepareStatement("SELECT MAX(id) AS last_booking_id FROM book_details");
                    ResultSet rs = psGetCustomerId.executeQuery();
                    if (rs.next()) {
                        lastBookingId = rs.getInt("last_booking_id");
                        System.out.println("cust id in saverecords:" + lastBookingId);
                        bookid = lastBookingId;
                        System.out.println("cust id in saverecords1:" + bookid);
                    } else {
                        System.out.println("Failed to retrieve the inserted customer ID");
                    }
                 // Close PreparedStatement
                con.close(); // Close Connection
            
        } catch (Exception e) {
        }
       
        return bookid;

    }
public static void saveintable(BookingDetails u,int total){
    int lastBookingId, bookid = 0;
        int rowsAffected = 0;
        String url="";
        try {
            Connection con = getConnection();
            String ss = getmydetails(u);
            String movies = u.getmovies();
           if ("Bhagawanth Kesari".equals(movies)) {
               url = "https://www.filmibeat.com/fanimg/movie/21180/bhagavanth-kesari-photos-images-85424.jpg";
           }
           if ("Leo".equals(movies)) {
               url = "https://ih1.redbubble.net/image.5297312179.5820/flat,750x,075,f-pad,750x1000,f8f8f8.jpg";
           }
           if ("Salaar".equals(movies)) {
               url = "https://i.pinimg.com/736x/f0/64/3f/f0643f638f85f73f878245ad84fd63bc.jpg";
           }
           if ("BTS:Yet To Come".equals(movies)) {
               url = "https://images-na.ssl-images-amazon.com/images/I/81%2BggV5X6SL.jpg";
           }

            if (movies != null) {
                PreparedStatement ps = con.prepareStatement("insert into book_details(moviename,theatrename,timings,seats_booked,total_price,url) values(?,?,?,?,?,?)");
                ps.setString(1, u.getmovies());
                ps.setString(2, u.gettheatres());
                ps.setString(3, u.gettimings());
                ps.setString(4, ss);
                ps.setInt(5,total);
                ps.setString(6,url);
                rowsAffected = ps.executeUpdate();
            }
        }catch(Exception e){
            
        }

}

}