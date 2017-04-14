package servlets;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.Adresse;
import metier.Contact;
import service.Iservice;
import service.IserviceImpl;

/**
 * Servlet implementation class AjouterAdresse
 */
@WebServlet("/AjouterContact")
public class AjouterContact extends HttpServlet {
	private static final long serialVersionUID = 1L;
       Iservice service = new IserviceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjouterContact() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("email");
		Contact c = new Contact();
		c.setEmail(email);
		c.setNom(nom);
		c.setPrenom(prenom);
		
		Adresse a = new Adresse();
		a.setVille(request.getParameter("ville"));
		a.setCodePostal(request.getParameter("cp"));
		a.setNumRue(request.getParameter("rue"));
		int id = service.ajouterContactAdresse(c, a);
		
		request.setAttribute("contact", c);
		
	}

}
