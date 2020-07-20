package de.uniba.dsg.dsam.backend.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class CustomerOrderEntity{
	@Id //Primary Key
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private java.sql.Date date;
	private int totalbeverages;
	@ManyToOne(optional = true)
	private BeverageEntity bvgfk;

	public BeverageEntity getbvgfk() {
		return bvgfk;
	}

	/**
	 * @param division the division to set
	 */
	public void setbvgfk(BeverageEntity bvgFK) {
		this.bvgfk = bvgFK;
	}

	public int getId() {
		return id;
	}

	public void setId(int ID) {
		this.id = ID;
	}

	public java.sql.Date getDate() {
		return getDate();
	}

	public void setDate(java.sql.Date date) {
		this.date = date;
	}

	public int getSoldBeverages() {
		return totalbeverages;
	}

	public void setSoldBeverages(int nr_beverages) {
		this.totalbeverages = nr_beverages;
	}
}
