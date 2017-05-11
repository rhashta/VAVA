package sk.fiit.ais.beans;

import java.util.List;

import javax.ejb.Remote;

import sk.fiit.ais.entity.Excercise;

@Remote
public interface GetExcerciseBeanRemote {
	
	public List<Excercise> getData(int id);

}
