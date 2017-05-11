package sk.fiit.ais.entity;

import java.io.Serializable;

public class Excercise implements Serializable{
	
	private String subject_name;
	private int startTime;
    private int length;
    
    public Excercise(){
    	
    }
    
	   
	   public String getSubjectName() {
		  return subject_name;
	   }

	   public void setSubjectName(String subject_name) {
		  this.subject_name = subject_name;
	   }	   
	   
	   public int getStartTime(){
		   return startTime;
	   }
	   
	   public void setStartTime(int startTime){
		   this.startTime = startTime;
	   }
	   
	   public int getLength(){
		   return length;
	   }
	   
	   public void setLength(int length){
		   this.length = length;
	   }
	
}
