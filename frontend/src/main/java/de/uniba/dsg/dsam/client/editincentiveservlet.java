package de.uniba.dsg.dsam.client;

import java.io.IOException;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.uniba.dsg.dsam.model.dtos.incentiveDTO;
import de.uniba.dsg.dsam.persistence.IncentiveManagement;

public class editincentiveservlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(editincentiveservlet.class.getName());

	public editincentiveservlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@EJB
	IncentiveManagement incMgt;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		if (req.getParameter("div_id") != null) {
			int id = Integer.valueOf(req.getParameter("div_id"));
			incentiveDTO div = incMgt.getIncentive(id);
			req.setAttribute("div", div);
			req.getRequestDispatcher("/editincentive.jsp").forward(req, res);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	      throws ServletException, IOException {
		int id = Integer.valueOf(request.getParameter("div_id"));
		String name = request.getParameter("div_name").trim();
		incMgt.update(id, name);
		response.sendRedirect("/frontend/incentiveservlet");
	}
}
