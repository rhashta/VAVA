package sk.fiit.ais.entity;

import java.io.Serializable;

public class Teacher implements Serializable{
	
	private int id;
	private String firstName;
	private String lastName;
	
	public Teacher(){
		
	}
	
	   public int getId() {
	      return id;
	   }

	   public void setId(int id) {
	      this.id = id;
	   }

	   public String getFistName() {
	      return firstName;
	   }

	   public void setFirstName(String firstName) {
	      this.firstName = firstName;
	   }
	   
	   public String getLastName() {
		  return lastName;
	   }

	   public void setLastName(String lastName) {
		  this.lastName = lastName;
	   }

}
