package de.uniba.dsg.dsam.model.dtos;

import java.io.Serializable;
import java.sql.Date;

public class customerOrderDTO implements Serializable{

	
	private int id;
	private java.sql.Date date;	 
	private int totalbeverages;
	private int bvgfk;
	
	public customerOrderDTO() { }
	
	public customerOrderDTO(int totalBvg, int bvgFk , Date a) { 
		
		this();
		this.totalbeverages = totalBvg;
		this.bvgfk = bvgFk;
		this.date=a;
		
	}
	
	
	
	public int getId(){
		return id;
	}
	
	public void setId(int ID){
		this.id = ID;
	}
	
	
	public java.sql.Date getDate() {
	    return getDate();
	  }

	public void setDate(java.sql.Date date) {
	    this.date = date;
	  }

	public int getTotalbeverages() {
		return totalbeverages;
	}

	public void setTotalbeverages(int totalbeverages) {
		this.totalbeverages = totalbeverages;
	}

	public int getBvgfk() {
		return bvgfk;
	}

	public void setBvgfk(int bvgfk) {
		this.bvgfk = bvgfk;
	}
	
}
