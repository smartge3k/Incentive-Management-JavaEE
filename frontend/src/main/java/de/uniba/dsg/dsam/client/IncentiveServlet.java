package de.uniba.dsg.dsam.client;

import java.io.IOException;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.uniba.dsg.dsam.persistence.IncentiveManagement;

/**
 * Servlet implementation class IncentiveServlet
 */
public class IncentiveServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(IncentiveServlet.class.getName());
	@EJB
	IncentiveManagement incMgt;

	public IncentiveServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//incMgt.temp();
		request.setAttribute("incentivelist", incMgt.getincentives());
		request.getRequestDispatcher("/mainincentive.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	      throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("div_name").trim();
		String type = request.getParameter("div_type").trim();
		incMgt.create(name, type); //dtype shows what manager selected to create what type of incetnvie
		doGet(request, response);
	}

	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		try {
			int id = Integer.valueOf(request.getParameter("div_id"));
			incMgt.delete(id);
		} catch (NumberFormatException e) {
			logger.severe("Unable to Delete");
		}
	}
}
