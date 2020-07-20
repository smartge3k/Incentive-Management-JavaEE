package de.uniba.dsg.dsam.model.dtos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


import de.uniba.dsg.dsam.model.Incentive;

public final class beverageDTO implements Serializable {
	     
public static final double INVALID_VALUE = -1;
	
	    private int id;
	    private String type;
	    private String name;
	    private int quantity;
	    private double price;
        private int incentive;
	

		
	    public beverageDTO() {
	    	// TODO Auto-generated constructor stub
	    }
        public beverageDTO (int id,String n , double p, int q , String t , int i) {
	   
	   
	   this();
	   this.setType(t);
	   this.setName(n);
	   this.setQuantity(q);
	   this.setPrice(p);
	   this.setIncentive(i);
	   this.id=id;
	   
	   
	   
   }
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getQuantity() {
			return quantity;
		}
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}
	
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public int getIncentive() {
			return incentive;
		}
		public void setIncentive(int incentive) {
			this.incentive = incentive;
		}



}
