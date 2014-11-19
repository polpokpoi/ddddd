package com.sprhib.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;




@Entity
public class LecturePlan extends Plan implements Serializable{
   
	
	
	 public LecturePlan(){}
	  public LecturePlan(String title, Date start, Date end, String color, String Letc){
		  super(title, start, end, color);
		  this.Letc =Letc;
		  
	  }
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1047102293812272525L;

	private String Letc;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Schedule schedule;

	
	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}
	public String getLetc() {
		return Letc;
	}

	public void setLetc(String letc) {
		Letc = letc;
	}
}
