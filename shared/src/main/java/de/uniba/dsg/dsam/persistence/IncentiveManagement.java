package de.uniba.dsg.dsam.persistence;

import java.util.List;


import de.uniba.dsg.dsam.model.dtos.incentiveDTO;

public interface IncentiveManagement {
	
	 public void create(String name, String type);
	 List<incentiveDTO> getincentives();
	incentiveDTO getIncentive(int divID);
	public void update(int id, String name);
	public void delete(int divID);
	public void temp();
	 
	
}
