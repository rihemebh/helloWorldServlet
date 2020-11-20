

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InsertionEtudiant
 */
@WebServlet("/InsertionEtudiant")
public class InsertionEtudiant extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private static ArrayList<etudiant> etudiants = new ArrayList<etudiant>();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertionEtudiant() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nom =request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		int age = Integer.parseInt(request.getParameter("age"));
		String filiere = request.getParameter("filiere");
		etudiant et= new etudiant(nom,prenom,filiere,age);
		etudiants.add(et);
		
		PrintWriter out = response.getWriter();
		out.println("<html><head><style>");
		out.println( "table,th,td{ border:2px solid black;border-collapse:collapse;}");
		out.println("</style></head><body><table<tr><td>nom</td><td>prenom</td><t>age</td><td>filiere</td></tr>");
		for(int i=0; i<etudiants.size(); i++) {
		         	out.println("<tr>");
					out.println("<td>"+etudiants.get(i).nom+"</td>");
					out.println("<td>"+etudiants.get(i).prenom+"</td>");
					out.println("<td>"+etudiants.get(i).age+"</td>");
					out.println("<td>"+etudiants.get(i).filiere+"</td>");
					out.println("</tr>");
			}
			
		out.println("</table></body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
 class etudiant{
	 
	 public String nom;
	 public String prenom ;
	 public String filiere;
	 public int age;
	 
	 etudiant(String nom, String prenom, String filiere, int age) {
		this.nom = nom;
		this.prenom = prenom;
		this.filiere = filiere; 
		this.age = age;
	}
	 
	 
 }