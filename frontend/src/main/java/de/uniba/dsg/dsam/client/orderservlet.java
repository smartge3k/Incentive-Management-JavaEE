package de.uniba.dsg.dsam.client;

import java.io.IOException;
import java.sql.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.uniba.dsg.dsam.model.dtos.customerOrderDTO;
import de.uniba.dsg.dsam.persistence.SalesManagement;

/**
 * Servlet implementation class orderservlet
 */
public class orderservlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(orderservlet.class.getName());
	@EJB
	QueueOrderSender sender;
	@EJB
	SalesManagement getOrdr;

	public orderservlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("totalsalesWithoutIncentives", getOrdr.totalsalesWithoutIncentives());
		request.setAttribute("totalsalesWithIncentive", getOrdr.totalsalesWithIncentive());
		request.setAttribute("OrdersList", getOrdr.getOrders());
		logger.info("Usman4");
		request.getRequestDispatcher("/mainorder.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int totalbvg = Integer.parseInt(req.getParameter("div_bvg").trim());
		int bvgfk = Integer.parseInt(req.getParameter("div_bvgfk").trim());
		customerOrderDTO ordr = new customerOrderDTO();
		long millis = System.currentTimeMillis();
		Date d = new Date(millis);
		ordr.setDate(d);
		ordr.setTotalbeverages(totalbvg);
		ordr.setBvgfk(bvgfk);
		sender.sendMessage(ordr);
		doGet(req, res);
	}
}
