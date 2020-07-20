package de.uniba.dsg.dsam.backend.beans;

import java.util.logging.Logger;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import de.uniba.dsg.dsam.model.dtos.customerOrderDTO;
import de.uniba.dsg.dsam.persistence.SalesManagement;

@MessageDriven(mappedName = "BeverageStoreQueue", activationConfig = {
      @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue") })
public class NewOrderMDB implements MessageListener{
	private static final Logger logger = Logger.getLogger(NewOrderMDB.class.getName());
	@EJB
	SalesManagement saleMgt;

	public NewOrderMDB() {
	}

	@Override
	public void onMessage(Message message) {
		if (message == null) {
			return;
		}
		try {
			Object o = ((ObjectMessage) message).getObject();
			saleMgt.create((customerOrderDTO) o);
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
}
