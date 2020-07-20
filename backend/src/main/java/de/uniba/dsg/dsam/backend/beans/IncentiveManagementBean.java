package de.uniba.dsg.dsam.backend.beans;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import de.uniba.dsg.dsam.backend.entities.BeverageEntity;
import de.uniba.dsg.dsam.backend.entities.IncentiveEntity;
import de.uniba.dsg.dsam.backend.entities.PromotionalGiftEntity;
import de.uniba.dsg.dsam.backend.entities.TrialPackageEntity;
import de.uniba.dsg.dsam.model.PromotionalGift;
import de.uniba.dsg.dsam.model.dtos.beverageDTO;
import de.uniba.dsg.dsam.model.dtos.incentiveDTO;
import de.uniba.dsg.dsam.persistence.IncentiveManagement;

@Stateless
@Remote(IncentiveManagement.class)
public class IncentiveManagementBean implements IncentiveManagement{
	private static final Logger logger = Logger.getLogger(BeverageManagementBean.class.getName());
	@PersistenceContext(type = PersistenceContextType.TRANSACTION)
	EntityManager em;

	//Created temp() to auto add an incentive when servlet is loaded, not used in the actual assignment
	public void temp() {
		IncentiveEntity test_inc = new TrialPackageEntity(); //Temp Value to be add hardcore
		test_inc.setName("Usman");
		em.persist(test_inc);
	}

	public void create(String name, String type) {
		IncentiveEntity a = null;
		List<IncentiveEntity> divs = em.createNamedQuery("getallincentives").getResultList();
		if (IncentivealreadyExists(divs, name)) {
			logger.info("Incentive with same name already exists.");
		} else {
			String b = type.toString();
			switch (b) {
			case "TrialPackageEntity":
				a = new TrialPackageEntity();
				a.setName(name);
				em.persist(a);
				break;
			default:
				a = new PromotionalGiftEntity();
				a.setName(name);
				em.persist(a);
			}
		}
	}

	@Override
	public List<incentiveDTO> getincentives() {
		List<IncentiveEntity> divs = em.createNamedQuery("getallincentives").getResultList();
		if (divs.isEmpty()) {
			return new ArrayList<incentiveDTO>();
		} else {
			List<incentiveDTO> a = new ArrayList<>();
			String holder;
			int hold;
			for (IncentiveEntity element : divs) {
				holder = element.getName().toString();
				hold = element.getid();
				a.add(new incentiveDTO(hold, holder));
			}
			return a;
		}
	}

	@Override
	public incentiveDTO getIncentive(int divID) {
		IncentiveEntity d = em.find(IncentiveEntity.class, new Integer(divID));
		if (d == null)
			return null;
		else {
			return convert(d);
		}
	}

	private incentiveDTO convert(IncentiveEntity r) {
		return new incentiveDTO(r.getid(), r.getName());
	}

	@Override
	public void update(int id, String name) {
		List<IncentiveEntity> forcheck = em.createNamedQuery("getallincentives").getResultList();
		IncentiveEntity div = em.find(IncentiveEntity.class, new Integer(id));
		if (IncentivealreadyExists(forcheck, name)) {
			logger.info("Incentive with same name already exists.");
		} else {
			div.setName(name);
			em.persist(div);
		}
	}

	private boolean IncentivealreadyExists(List<IncentiveEntity> divs, String name) {
		boolean a = false;
		if (divs.isEmpty()) {
			a = false;
		} else {
			for (IncentiveEntity element : divs) {
				if (element.getName().equals(name)) {
					return true;
				}
			}
		}
		return a;
	}

	@Override
	public void delete(int divID) {
		IncentiveEntity a = em.find(IncentiveEntity.class, new Integer(divID));
		em.remove(a);
		em.flush();
	}
}
