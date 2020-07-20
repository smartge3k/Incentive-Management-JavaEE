package de.uniba.dsg.dsam.persistence;

import java.sql.Date;
import java.util.List;

import de.uniba.dsg.dsam.model.dtos.customerOrderDTO;

public interface SalesManagement {
	
	public void create(customerOrderDTO d);

	public List<customerOrderDTO> getOrders();
	public int totalsalesWithIncentive();
	public int totalsalesWithoutIncentives();
	
	
}
