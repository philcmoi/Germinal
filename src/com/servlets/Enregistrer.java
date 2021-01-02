package com.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import codage.Cryptage;

/**
 * Servlet implementation class Traitement2
 */
@WebServlet("/Enregistrer")
public class Enregistrer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Enregistrer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	
//		Cookie[] cookies = request.getCookies();
//        if (cookies != null) {
//            for (Cookie cookie : cookies) {
//                if (cookie.getName().equals("email")) {
//                    request.setAttribute("emailText", cookie.getValue());
//                    String message = cookie.getValue();
//                    request.setAttribute("text", message);
//                }
//            }
//        }
        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
//			Class.forName("com.mysql.jdbc.Driver");

		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			System.out.println("mysql cj");
			e1.printStackTrace();
		}
		
		
		try {
			
			Connection connection = null ;
				
	        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/germinal?serverTimezone=UTC","root","L099339RWFH");

			String pseudo = request.getParameter("pseudo");
			String email = request.getParameter("email");
			String motpasse = request.getParameter("password");
			String motpasse2 = request.getParameter("password2");
			String token = request.getParameter("token");
//			token = ((Double)(Math.random() * 10000)).toString();
			String validate = request.getParameter("validate");
//			String cook = request.getParameter("rememberme");

			ResultSet resultatMail;
			ResultSet resultatPseudo;

			PreparedStatement preparedStatementMail = connection.prepareStatement("SELECT * FROM membre WHERE email= ?");
			
			email = Cryptage.crypter(email,"valeur");
			
			preparedStatementMail.setString(1,email);

			
			resultatMail = preparedStatementMail.executeQuery();
			
			PreparedStatement preparedStatementPseudo = connection.prepareStatement("SELECT * FROM membre WHERE pseudo= ?");
			preparedStatementPseudo.setString(1,pseudo);

			resultatPseudo = preparedStatementPseudo.executeQuery();


			if ( resultatPseudo.next()) {
					
					 String message = "Le pseudo est deja pris";
					 request.setAttribute("text", message);
					
					 request.getServletContext().getRequestDispatcher("/enregistrement.jsp").forward(request, response);
			
				
			} else if ( resultatMail.next()) {
					
					 String message = "l'email est deja pris";
					 request.setAttribute("text", message);
					
					 request.getServletContext().getRequestDispatcher("/enregistrement.jsp").forward(request, response);
				
				
				
				 }
			else if ( !motpasse.equals(motpasse2)) {
				
				 String message = "Veulliez saisir des mots de passe semblables";
				 request.setAttribute("text", message);
				
				 request.getServletContext().getRequestDispatcher("/enregistrement.jsp").forward(request, response);
				
			}
			 else {
			
			motpasse = Cryptage.crypter(motpasse,"valeur");
//			email = Cryptage.crypter(email,token);
			token = ((Double)(Math.random() * 10000)).toString();
			token = Cryptage.crypter(token,"valeur");
				 
			String sql = "INSERT INTO membre (pseudo, email, motpasse, token, validate) VALUES(?,?,?,?,?)"; 
			PreparedStatement statement = connection.prepareStatement(sql); 
			//en spécifiant bien les types SQL cibles 
			statement.setObject(1,pseudo, Types.VARCHAR); 
			statement.setObject(2,email,Types.VARCHAR);
			statement.setObject(3,motpasse,Types.VARCHAR);
			statement.setObject(4,token,Types.VARCHAR);
			statement.setObject(5,validate,Types.VARCHAR);

			statement.executeUpdate();
			

										
			String message = "Un mail vient d'être envoyé dans votre de réception mail, veuilliez le valider en clicquant sur le lien fourni";
	        request.setAttribute("text", message);	
	

	        
			request.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		}
			
									
		
		}
		catch (Exception e) {
		// TODO Auto-generated catch block
		System.out.println("Erreure sql");
		e.printStackTrace();
	} 
		finally {System.out.println("fin enregistrement");}	
	
	}	
	
}
