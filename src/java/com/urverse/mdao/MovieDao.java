package com.urverse.mdao;
import com.urverse.movies.MovieDetails;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
public class MovieDao {
    public static Connection getConnection(){
	Connection con=null;
	try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","admin");
	}catch(Exception e){System.out.println(e);}
	return con;
}
 public static List<MovieDetails> getAllRecords(){
	List<MovieDetails> list=new ArrayList<MovieDetails>();
	
	try{
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("select * from movie_desc");
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			MovieDetails u=new MovieDetails();
			//u.setid(rs.getInt("id"));
			u.setmovie_desc(rs.getString("movie_desc"));
			u.settime(rs.getString("time"));
			u.setgenre(rs.getString("genre"));
			u.setrating(rs.getString("rating"));
                        u.setlikes(rs.getString("likes"));
                        u.setyear(rs.getString("year"));
                        u.setimage(rs.getString("image"));
                         u.setmoviename(rs.getString("moviename"));
			list.add(u);
                        System.out.println();
		}
                System.out.println("Data:"+list);
	}catch(Exception e){System.out.println(e);}
	return list;
}
  public static int save(MovieDetails u){
	int status=0; 
	try{
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("insert into movie_desc(movie_desc,time,genre,rating,likes,year,image,moviename) values(?,?,?,?,?,?,?,?)");
		ps.setString(1,u.getmovie_desc());
		ps.setString(2,u.gettime());
                ps.setString(3,u.getgenre());
                ps.setString(4,u.getrating());
                ps.setString(5,u.getlikes());
                ps.setString(6,u.getyear());
                ps.setString(7,u.getimage());
                ps.setString(8,u.getmoviename());
		status=ps.executeUpdate();
	}catch(Exception e){System.out.println(e);}
	return status;
}
    
    
}
