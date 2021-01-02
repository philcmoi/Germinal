package com.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import codage.Cryptage;
import email.SendEmailHTML;
/**
 * Servlet implementation class PasseOublie
 */
@WebServlet("/PasseOublie")
public class PasseOublie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PasseOublie() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
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

			
			String emailOublie = request.getParameter("emailOublie");
			emailOublie = Cryptage.crypter(emailOublie,"valeur");

			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM membre WHERE email= ?");
		
			preparedStatement.setString(1,emailOublie);
			
			ResultSet resultat = preparedStatement.executeQuery();

			if ( resultat.next()) {
				
				
				
				
				
				String message = "un mail vous a ete envoyer à l'adresse de votre boite mail" ;
		        request.setAttribute("text", message);	

				request.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
				}
			 else
	        {
	        String message = "l'email  est incorrect";
	        request.setAttribute("message", message);	
	    
			request.getServletContext().getRequestDispatcher("/rappelleMotPasse.jsp").forward(request, response);
	        }

		
			
		}catch (Exception e) {
			// TODO Auto-generated catch block

			System.out.println("Erreure sql");
			e.printStackTrace();
							 }
	}

}
