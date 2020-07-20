package de.uniba.dsg.dsam.backend.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TrialPackageEntity extends IncentiveEntity{
	@Id
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String promoname) {
		this.name = promoname;
	}
}
