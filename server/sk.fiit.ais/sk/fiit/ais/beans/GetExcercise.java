package sk.fiit.ais.beans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import sk.fiit.ais.entity.Excercise;

/**
 * Session Bean implementation class GetExcercise
 */
@Stateless
public class GetExcercise implements GetExcerciseRemote {

	@Override
	public List<Excercise> logOn(int id) {
		
		List<Excercise> result = new ArrayList<Excercise>();
		
		
		
		return null;
	}



}
