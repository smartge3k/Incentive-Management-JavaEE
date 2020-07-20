package de.uniba.dsg.dsam.backend.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
public class BeverageEntity implements Serializable{
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String Beverage_name;
	private int quantity;
	private double price;
	private String manufacturer;;
	//One beverage can belong to multiple records in the CustomerOrders
	//Eager Does
	@OneToMany(mappedBy = "bvgfk", fetch = FetchType.EAGER)
	private List<CustomerOrderEntity> orders;
	@ManyToOne(optional = true)
	private IncentiveEntity incfk;

	public IncentiveEntity getincfk() {
		return incfk;
	}

	/**
	 * @param division the division to set
	 */
	public void setincfkk(IncentiveEntity incFK) {
		this.incfk = incFK;
	}

	/**
	 * @param rooms the rooms to set
	 */
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setprice(double priceb) {
		this.price = priceb;
	}

	public double getprice() {
		return price;
	}

	public String getBeverage_name() {
		return Beverage_name;
	}

	public void setBeverage_name(String beverage_name) {
		Beverage_name = beverage_name;
	}

	public List<CustomerOrderEntity> getorders() {
		if (this.orders == null)
			return new ArrayList<CustomerOrderEntity>();
		else
			return new ArrayList<CustomerOrderEntity>(this.orders);
	}

	/**
	 * @param rooms the rooms to set
	 */
	public void setorders(List<CustomerOrderEntity> or) {
		this.orders = or;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
}
