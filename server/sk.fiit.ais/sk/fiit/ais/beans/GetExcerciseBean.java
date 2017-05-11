package sk.fiit.ais.beans;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import sk.fiit.ais.connection.db_connection;
import sk.fiit.ais.entity.Excercise;

/**
 * Session Bean implementation class GetExcercise
 */
@Stateless
public class GetExcerciseBean implements GetExcerciseBeanRemote {

	@Override
	public List<Excercise> getData(int id) {
		
		List<Excercise> result = new ArrayList<Excercise>();
		
		try {
			
			PreparedStatement st = db_connection.getConnection()
					.prepareStatement("select c.Name, b.StartTime, b.Length from Student_Excercise a join Excercise b on a.IdExcercise = b.id "
							+ "join Subject c on c.id = b.IdSubject where a.IdStudent = (?) ");
			
    		st.setString(1, Integer.toString(id));
    		
    		ResultSet rs = st.executeQuery();
    		
    		Excercise ex;
            while (rs.next()) {
               ex = new Excercise();
               ex.setSubjectName(rs.getString(1));                 
               ex.setStartTime(rs.getInt(2));
               ex.setLength(rs.getInt(3));
               result.add(ex);
            }
			
			return result;
            
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}



}
