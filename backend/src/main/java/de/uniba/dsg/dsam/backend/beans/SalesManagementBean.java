package de.uniba.dsg.dsam.backend.beans;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import de.uniba.dsg.dsam.backend.entities.BeverageEntity;
import de.uniba.dsg.dsam.backend.entities.CustomerOrderEntity;
import de.uniba.dsg.dsam.model.dtos.customerOrderDTO;
import de.uniba.dsg.dsam.persistence.BeverageManagement;
import de.uniba.dsg.dsam.persistence.SalesManagement;

@Stateless
@Local(SalesManagement.class)
public class SalesManagementBean implements SalesManagement{
	private static final Logger logger = Logger.getLogger(SalesManagementBean.class.getName());
	@PersistenceContext(type = PersistenceContextType.TRANSACTION)
	EntityManager em;

	public void create(customerOrderDTO rrd) {
		BeverageEntity a = em.find(BeverageEntity.class, new Integer(rrd.getBvgfk()));
		if (a == null) {
			logger.info("Cannot find any beverage to assign to this order ");
		} else {
			CustomerOrderEntity r = new CustomerOrderEntity();
			long millis = System.currentTimeMillis();
			java.sql.Date d = new java.sql.Date(millis);
			r.setDate(d);
			r.setSoldBeverages(a.getQuantity());
			r.setbvgfk(a);
			em.persist(r);
		}
	}

	@Override
	public List<customerOrderDTO> getOrders() {
		List<customerOrderDTO> a = new ArrayList<>();
		List<CustomerOrderEntity> divs = (List<CustomerOrderEntity>) em.createQuery("SELECT c FROM CustomerOrderEntity c")
		      .getResultList();
		if (divs.isEmpty()) {
			//logger.info("Usman1 ");
			return new ArrayList<customerOrderDTO>();
		} else {
			int totalbvg;
			int bvgfk;
			long millis = System.currentTimeMillis();
			java.sql.Date tempD = new java.sql.Date(millis);
			for (CustomerOrderEntity element : divs) {
				totalbvg = element.getSoldBeverages();
				bvgfk = element.getbvgfk().getId();
				a.add(new customerOrderDTO(totalbvg, bvgfk, tempD));
			}
			return a;
		}
	}

	public int totalsalesWithIncentive() {
		List<CustomerOrderEntity> allOrders = (List<CustomerOrderEntity>) em.createNamedQuery("getallorders")
		      .getResultList();
		int totalsalesWithIncentive = 0;
		if (allOrders == null) {
			totalsalesWithIncentive = 0;
		} else {
			for (CustomerOrderEntity temp : allOrders) {
				if (temp.getbvgfk().getincfk() == null) {
					continue;
				} else {
					totalsalesWithIncentive += temp.getbvgfk().getprice();
				}
			}
		}
		return totalsalesWithIncentive;
	}

	public int totalsalesWithoutIncentives() {
		List<CustomerOrderEntity> allOrders = (List<CustomerOrderEntity>) em.createNamedQuery("getallorders")
		      .getResultList();
		int totalsalesWithoutIncentives = 0;
		if (allOrders == null) {
			totalsalesWithoutIncentives = 0;
		} else {
			for (CustomerOrderEntity temp : allOrders) {
				if (temp.getbvgfk().getincfk() == null) {
					totalsalesWithoutIncentives += temp.getbvgfk().getprice();
				} else {
					continue;
				}
			}
		}
		return totalsalesWithoutIncentives;
	}
}
