package com.sprhib.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;





@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Plan  {
	
	 public Plan(){};
	 public Plan( String title, Date start, Date end, String color ){
		 this.title=title;
		 this.start = start;
		 this.end =end;
		 this.color = color;
	 }
	 
	
	@Id @GeneratedValue(strategy=GenerationType.TABLE)
	private int id;
	private String title;
	private Date start;
	private Date end;
	private String color;
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getStart() {
		return start;
	}
	public void setStart(Date start) {
		this.start = start;
	}
	public Date getEnd() {
		return end;
	}
	public void setEnd(Date end) {
		this.end = end;
	}
	
	
	
	
	
}
