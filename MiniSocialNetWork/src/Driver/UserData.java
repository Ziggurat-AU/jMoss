package Driver;
import java.util.ArrayList;

//public class UserData {
//	
//	ArrayList<UserNodes> data;
//	
//	////////// For keep track of the information, use the key value link to the profile. 
//	////////// How to show the each time updated information.
//	////////// When you face these questions how do you solve them?What is your each step's 
//	////////// coding the concrete codes. 
//	
//	public UserData () {
//		
//		   data= new ArrayList<UserNodes>();
//	
//		   data.add(new Adulttt("Alan","Studnet",18));
//		   data.add(new Adulttt("Ellen","Teacher",28));
//		   data.add(new Adulttt("Jay","professor",38));
//		
//		///////realize the delete, add ,select(boolean)......? through array List? 		
//		//thread
//		//operating system
//	    //add friendship
//		  data.get(0).makeFriend(data.get(1)); 
//	}
//}



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import org.hsqldb.Server;

public class UserData {
	public static void main(String[] args) {
		Server hsqlServer = null;
		Connection connection = null;
		ResultSet rs = null;
		hsqlServer = new Server();
		hsqlServer.setLogWriter(null);
		hsqlServer.setSilent(true);
		hsqlServer.setDatabaseName(0, "TestDB");
		hsqlServer.setDatabasePath(0, "file:MYDB");
		hsqlServer.start();
		// making a connectiontry {
		Class.forName("org.hsqldb.jdbcDriver");
		connection = DriverManager.getConnection("jdbc:hsqldb:TestDB", "sa", "123");
		connection.prepareStatement("drop table barcodes if exists;").execute();
		connection.prepareStatement("create table barcodes (id integer, barcode varchar(20) not null);").execute();
		connection.prepareStatement("insert into barcodes (id, barcode)"+ "values (1, '12345577');").execute();////           
		// query from the dbrs = connection.prepareStatement("select id, barcode  from barcodes;").executeQuery();
		rs.next();System.out.println(String.format("ID: %1d, Name: %1s", rs.getInt(1), rs.getString(2)));
		connection.commit();} 
	catch (SQLException e2) {e2.printStackTrace();} 
	catch (ClassNotFoundException e2) {e2.printStackTrace();}
	}
}
//end of stub code for in/out stub}}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	