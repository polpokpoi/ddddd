package com.sprhib.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="DayPlan")
public class DayPlan extends Plan implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3687592912148936051L;

	
	

	 public DayPlan(){}
	  public DayPlan(String title, Date start, Date end, String color, String Detc){
		  super(title, start, end, color);
		  this.Detc =Detc;
		  
	  }
	
	
	

	@ManyToOne(cascade = CascadeType.ALL)
	private Schedule schedule;
	 
	



	private String Detc;

	public String getDetc() {
		return Detc;
	}


	
	public void setDetc(String detc) {
		Detc = detc;
	}

	 
		public Schedule getSchedule() {
			return schedule;
		}
		
		public void setSchedule(Schedule schedule) {
			this.schedule = schedule;
		}

}
