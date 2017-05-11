package sk.fiit.ais.beans;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.ejb.Stateless;

import sk.fiit.ais.connection.db_connection;
import sk.fiit.ais.entity.Student;

/**
 * Session Bean implementation class Login
 */
@Stateless
public class LoginBean implements LoginBeanRemote {
	
	
	public Student logOn(int id) throws SQLException {
		
    	return connection(id);
    }
	
	private Student connection(int id) throws SQLException{
	    
		
	    try {
	    	
    		PreparedStatement st = db_connection.getConnection().prepareStatement("select a.name, a.surname from student a where a.id = (?)");
    		st.setString(1, Integer.toString(id));
    		
    		ResultSet rs = st.executeQuery();
    		
    		if (!rs.isLast()){
    			return null;
    		} else {    		
    			Student student = new Student();
    			
    			student.setId(id);
    			student.setFirstName(rs.getString("name"));
    			student.setLastName(rs.getString("surname"));
    			
    			return student;
    		}
    			
	    } catch (Exception ex) {
	    	
	    	ex.printStackTrace();
	    	return null;
	    }
	}

}
