package sk.fiit.ais.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class db_connection {
	
	
	public static Connection GetConnection(){
		
		Connection con = null;
	    String url = "jdbc:postgresql://localhost:5432/postgres";
	    String driver = "org.postgresql.driver";

	    String userName = "postgres";
	    String password = "vava";
	    
	    try {
	    	
	    	Class.forName(driver).newInstance();
    		con = DriverManager.getConnection(url , userName, password);
    		
    		return con;
	    	
	    } catch (Exception ex) {
	    	
	    	ex.printStackTrace();
	    	return null;
	    }
	}
}
