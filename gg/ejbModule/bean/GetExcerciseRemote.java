package bean;

import java.util.List;

import javax.ejb.Remote;

import model.Excercise;

@Remote
public interface GetExcerciseRemote {
	
	public List<Excercise> logOn(int id);

}
