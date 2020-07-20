package de.uniba.dsg.dsam.client;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ejb.EJB;

import java.util.List;
import java.util.logging.Logger;

import de.uniba.dsg.dsam.model.Beverage;
import de.uniba.dsg.dsam.model.Incentive;
import de.uniba.dsg.dsam.model.dtos.beverageDTO;
import de.uniba.dsg.dsam.persistence.BeverageManagement;
import de.uniba.dsg.dsam.persistence.IncentiveManagement;

/**
 * Servlet implementation class beverage
 */
public class BeverageServlet extends HttpServlet{
	private static final Logger logger = Logger.getLogger(BeverageServlet.class.getName());
	private static final long serialVersionUID = 1L;

	public BeverageServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@EJB
	BeverageManagement bvgMgt;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("BevereagesList", bvgMgt.getBeverages());
		request.getRequestDispatcher("/main.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	      throws ServletException, IOException {
		final Logger logger = Logger.getLogger(BeverageServlet.class.getName());
		try {
			String name = request.getParameter("div_name").trim();
			String type = request.getParameter("div_type").trim();
			int qty = Integer.parseInt(request.getParameter("div_quantity"));
			double price = Double.valueOf(request.getParameter("div_price"));
			int in;
			String ContainsIncentive = request.getParameter("div_incentive");
			if (ContainsIncentive.isEmpty()) { //To Check incentive is assigned or not
				in = 0;
			} else {
				in = Integer.parseInt(request.getParameter("div_incentive"));
			}
			bvgMgt.create(name, price, qty, type, in);
		} catch (NumberFormatException e) {
			logger.severe("Invalid Data" + e.getMessage());
		}
		// redirect
		response.sendRedirect("/frontend/beverages");
	}

	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		try {
			int id = Integer.valueOf(request.getParameter("div_id"));
			bvgMgt.delete(id);
		} catch (NumberFormatException e) {
			logger.severe("Unable to Delete");
		}
	}
}
