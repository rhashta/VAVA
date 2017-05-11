package sk.fiit.ais.beans;

import java.sql.SQLException;

import javax.ejb.Remote;

import sk.fiit.ais.entity.Student;

@Remote
public interface LoginBeanRemote {
	
	public Student logOn(int id) throws SQLException;
	
}
