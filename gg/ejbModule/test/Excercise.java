package test;

import java.io.Serializable;

public class Excercise implements Serializable{
	
	private int id;
	private int subject_id;
	private int startTime;
    private int length;
    
    public Excercise(){
    	
    }
    
       public int getId() {
	      return id;
	   }

	   public void setId(int id) {
	      this.id = id;
	   }
	   
	   public int getSubjectId() {
		  return subject_id;
	   }

	   public void setSubjectId(int subject_id) {
		  this.subject_id = id;
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
