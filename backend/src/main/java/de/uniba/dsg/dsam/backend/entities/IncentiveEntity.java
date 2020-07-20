package de.uniba.dsg.dsam.backend.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public abstract class IncentiveEntity{
	@Id //Primary Key
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String init_name;
	@OneToMany(mappedBy = "incfk", fetch = FetchType.EAGER)
	private List<BeverageEntity> bvgfk;

	public List<BeverageEntity> getbvgfk() {
		if (this.bvgfk == null)
			return new ArrayList<BeverageEntity>();
		else
			return new ArrayList<BeverageEntity>(this.bvgfk);
	}

	/**
	 * @param rooms the rooms to set
	 */
	public void getbvgfk(List<BeverageEntity> or) {
		this.bvgfk = or;
	}

	public int getid() {
		return this.id;
	}

	public String getName() {
		return init_name;
	}

	public void setName(String name) {
		this.init_name = name;
	}
}
