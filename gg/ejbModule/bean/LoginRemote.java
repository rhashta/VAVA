package bean;

import javax.ejb.Remote;

import model.Student;

@Remote
public interface LoginRemote {
	
	public Student logOn(int id);
	
}
