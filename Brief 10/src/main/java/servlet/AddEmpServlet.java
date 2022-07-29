package servlet;

import java.io.IOException;

import implimentation_DAO.EmployDaoImp;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Employe;

public class AddEmpServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private EmployDaoImp em;
	
    
    public void init() throws ServletException {
    	em = new EmployDaoImp();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String Prenom = request.getParameter("prenom");
		String nom = request.getParameter("nom");
		Double salaire = Double.parseDouble(request.getParameter("salaire"));
		String post = request.getParameter("post");
		String typecont = request.getParameter("typecont");
		
		em.addElemts(new Employe(Prenom, nom, salaire, post, typecont));

		response.sendRedirect("EmployeList.html");
		
	}

}
