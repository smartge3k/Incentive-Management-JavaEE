package de.uniba.dsg.dsam.backend.beans;

import javax.ejb.Stateless;

import de.uniba.dsg.dsam.backend.entities.BeverageEntity;
import de.uniba.dsg.dsam.backend.entities.IncentiveEntity;
import de.uniba.dsg.dsam.backend.entities.TrialPackageEntity;
import de.uniba.dsg.dsam.model.Beverage;
import de.uniba.dsg.dsam.model.dtos.beverageDTO;
import de.uniba.dsg.dsam.model.dtos.incentiveDTO;
import de.uniba.dsg.dsam.persistence.BeverageManagement;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.EJBException;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

@Stateless
@Remote(BeverageManagement.class)
public class BeverageManagementBean implements BeverageManagement{
	private static final Logger logger = Logger.getLogger(BeverageManagementBean.class.getName());
	@PersistenceContext(type = PersistenceContextType.TRANSACTION)
	EntityManager em;

	@Override
	public void create(String beverage_name, double price, int quantity, String type, int incid) {
		// TODO Auto-generated method stub
		if (incid == 0) { //if no incentive is assigned to the beverage
			BeverageEntity bvg = new BeverageEntity();
			bvg.setBeverage_name(beverage_name);
			bvg.setManufacturer(type);
			bvg.setQuantity(quantity);
			bvg.setprice(price);
			logger.info("Success");
			em.persist(bvg);
		} else {
			IncentiveEntity d = em.find(IncentiveEntity.class, new Integer(incid));
			if (d != null) {
				logger.info("Success");
				BeverageEntity bvg = new BeverageEntity();
				bvg.setBeverage_name(beverage_name);
				bvg.setManufacturer(type);
				bvg.setQuantity(quantity);
				bvg.setprice(price);
				bvg.setincfkk(d);
				em.persist(bvg);
			} else {
				logger.info("Could not add because the incentive you are trying to assign,does not exist");
			}
		}
	}

	@Override
	public List<beverageDTO> getBeverages() {
		List<BeverageEntity> divs = em.createNamedQuery("getallbeverages").getResultList();
		if (divs.isEmpty()) {
			return new ArrayList<beverageDTO>();
		} else {
			int i = 0;
			List<beverageDTO> a = new ArrayList<>();
			for (BeverageEntity element : divs) {
				int id = element.getId();
				String n = element.getBeverage_name().toString();
				String t = element.getManufacturer().toString();
				int q = element.getQuantity();
				double p = element.getprice();
				if (element.getincfk() != null) {
					i = element.getincfk().getid();
				} else
					i = 0;
				a.add(new beverageDTO(id, n, p, q, t, i));
			}
			return a;
		}
	}

	@Override
	public beverageDTO getBeverages(int divID) {
		BeverageEntity d = em.find(BeverageEntity.class, new Integer(divID));
		if (d == null) {
			//logger.info("Usman007");
			return null;
		} else {
			return convert(d);
		}
	}

	private beverageDTO convert(BeverageEntity r) {
		beverageDTO a = new beverageDTO();
		a.setId(r.getId());
		if (r.getincfk() == null) {
			a.setIncentive(0);
		} else {
			a.setIncentive(r.getincfk().getid());
		}
		a.setName(r.getBeverage_name());
		a.setPrice(r.getprice());
		a.setQuantity(r.getQuantity());
		a.setType(r.getManufacturer());
		return a;
	}

	@Override
	public void update(int id, String name, String type, int qty, double price, int incentive) {
		BeverageEntity a = em.find(BeverageEntity.class, new Integer(id));
		IncentiveEntity inc = em.find(IncentiveEntity.class, new Integer(incentive)); //to get assigned incentive
		a.setincfkk(inc);
		a.setBeverage_name(name);
		a.setprice(price);
		a.setQuantity(qty);
		a.setManufacturer(type);
		//em.merge(a);
	}

	@Override
	public void delete(int divID) {
		BeverageEntity a = em.find(BeverageEntity.class, new Integer(divID));
		em.remove(a);
	}
}
