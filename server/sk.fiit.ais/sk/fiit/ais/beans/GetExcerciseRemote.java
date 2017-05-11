package sk.fiit.ais.beans;

import java.util.List;

import javax.ejb.Remote;

import sk.fiit.ais.entity.Excercise;

@Remote
public interface GetExcerciseRemote {
	
	public List<Excercise> logOn(int id);

}
