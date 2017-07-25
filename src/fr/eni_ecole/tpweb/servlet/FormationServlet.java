package fr.eni_ecole.tpweb.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni_ecole.tpweb.bean.Formation;
import fr.eni_ecole.tpweb.dao.DAOFormation;
import fr.eni_ecole.tpweb.services.ServiceFormations;

/**
 * Servlet implementation class FormationServlet
 */
public class FormationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ServiceFormations serviceFormations;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormationServlet() {
        super();
    }

    /**
     * {@inheritDoc}
     * @see javax.servlet.GenericServlet#init()
     */
    @Override
    public void init() throws ServletException {
    	serviceFormations = new ServiceFormations();
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher rd = null;
		List<Formation> listeFormations;
		try {
			listeFormations = new DAOFormation().getAll();
			rd = getServletContext().getRequestDispatcher("formations.jsp");
			request.setAttribute("formations", listeFormations);
			rd.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("supprimer") != null){
			supprimerFormation(request, response);
		}else if(request.getParameter("modifier") != null){
			modifierFormation(request, response);
		}
	}

	/**
	 * Méthode en charge de supprimer la formation
	 * @param request
	 * @param response
	 */
	private void supprimerFormation(HttpServletRequest request,	HttpServletResponse response) {
		
	}
	
	/**
	 * Méthode en charge de 
	 * @param request
	 * @param response
	 */
	private void modifierFormation(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}
}
