package de.uniba.dsg.dsam.model.dtos;

import java.io.Serializable;

public final class incentiveDTO  implements Serializable{

	 private String name;
     private int id;
     
     
	 public incentiveDTO() {
			// TODO Auto-generated constructor stub
			
		}
	public incentiveDTO(int i ,String n) {
		// TODO Auto-generated constructor stub
		this.name = n;
		this.id=i;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	
	 
	 
	 

}
