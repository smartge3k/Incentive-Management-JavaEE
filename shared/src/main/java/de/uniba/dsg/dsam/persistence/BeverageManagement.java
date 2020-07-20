package de.uniba.dsg.dsam.persistence;



import java.util.List;

import de.uniba.dsg.dsam.model.Beverage;
import de.uniba.dsg.dsam.model.dtos.beverageDTO;
import de.uniba.dsg.dsam.model.dtos.incentiveDTO;

public interface BeverageManagement {
	

    public void create(String beverage_name,double price, int quantity, String type, int in);

    
	List<beverageDTO> getBeverages();


	public beverageDTO getBeverages(int id);


	void update(int id, String name, String type, int qty, double price, int incentive);




	void delete(int divID);
   
 

}
