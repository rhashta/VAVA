package sk.fiit.ais.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class db_connection {
	
	private static Connection con = setConnection();
	
	
	public static Connection getConnection(){
		
		return con;
	}
	
	private static Connection setConnection() {
		Connection con = null;
	    String url = "jdbc:postgresql://localhost:5432/VAVA";

	    String userName = "postgres";
	    String password = "vava";
	    
	    try {
	    	
	    	Class.forName("org.postgresql.Driver").newInstance();
    		con = DriverManager.getConnection(url , userName, password);
    		
    		return con;
	    	
	    } catch (Exception ex) {
	    	
	    	ex.printStackTrace();
	    	return null;
	    }
	}
}