package de.uniba.dsg.dsam.client;

import java.io.IOException;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.uniba.dsg.dsam.model.dtos.beverageDTO;
import de.uniba.dsg.dsam.model.dtos.incentiveDTO;
import de.uniba.dsg.dsam.persistence.BeverageManagement;

/**
 * Servlet implementation class EditBeverageServlet
 */
public class EditBeverageServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(EditBeverageServlet.class.getName());

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditBeverageServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@EJB
	BeverageManagement bvgMgt;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("div_id") != null) {
			int id = Integer.valueOf(request.getParameter("div_id"));
			beverageDTO div = bvgMgt.getBeverages(id);
			request.setAttribute("div", div);
			request.getRequestDispatcher("/editbeverage.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	      throws ServletException, IOException {
		int id = Integer.valueOf(request.getParameter("div_id"));
		String name = request.getParameter("div_name").trim();
		String type = request.getParameter("div_type").trim();
		int qty = Integer.parseInt(request.getParameter("div_quantity"));
		double price = Double.valueOf(request.getParameter("div_price"));
		int incentive = Integer.valueOf(request.getParameter("div_inc"));
		bvgMgt.update(id, name, type, qty, price, incentive);
		response.sendRedirect("/frontend/beverages");
	}
}
