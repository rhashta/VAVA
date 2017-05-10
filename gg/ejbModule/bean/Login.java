package bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.ejb.Stateless;

import model.Student;

/**
 * Session Bean implementation class Login
 */
@Stateless
public class Login implements LoginRemote {
	
	
	public Student logOn(int id) {
    	
		
		
    	return connection(id);
    }
	
	private Student connection(int id){
		Connection con = null;
	    String url = "jdbc:postgresql://localhost:5432/postgres";
	    String driver = "org.postgresql.driver";

	    String userName = "sa";
	    String password = "sa";
	    
	    try {
    		Class.forName(driver).newInstance();
    		con = DriverManager.getConnection(url , userName, password);
	    	
    		PreparedStatement st = con.prepareStatement("select a.name, a.surname from student a where a.id = (?)");
    		st.setString(1, Integer.toString(id));
    		
    		ResultSet rs = st.executeQuery();
    		
    		if (!rs.isLast())
    		{
    			Student student = new Student();
    			
    			student.setId(id);
    			student.setFirstName(rs.getString("name"));
    			student.setLastName(rs.getString("surname"));
    			return student;
    		} else {
    			return null;
    		}
    			
	    } catch (Exception ex) {
	    	ex.printStackTrace();
	    	return null;
	    }
	}

}
