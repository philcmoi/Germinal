package com.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import codage.Cryptage;


	@WebServlet("/Reponse")
	public class Reponse extends HttpServlet {
		
		
		
		private static final long serialVersionUID = 1L;
	 
		public Reponse() {super();}
	 
		@Override
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
//				Class.forName("com.mysql.jdbc.Driver");

			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				System.out.println("mysql cj");
				e1.printStackTrace();
			}
			
			
			String res;
			String mail = request.getParameter("mail").trim();
			String motPasse = request.getParameter("motPasse").trim();
			/* Connexion à la base de données */
			String url = "jdbc:mysql://localhost:3306/germinal";
			String utilisateur = "root";
			String motDePasse = "L099339RWFH";
			Connection connexion = null;

				
				


//		    System.out.println("MySQL JDBC Driver Registered!");
		    Connection connection = null;

		    try {
		        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/germinal?serverTimezone=UTC","root","L099339RWFH");

		        String sql = "SELECT idmembre FROM membre WHERE email= ? and motpasse= ?";
		        
//		        Statement statement =  connection.createStatement();
		        
		        PreparedStatement preparedStatement = connection.prepareStatement("SELECT idmembre FROM membre WHERE email= ? and motpasse= ?"); 
		        
		        preparedStatement.setString(1,mail);
		        preparedStatement.setString(2,Cryptage.crypter(motPasse,mail)); 

		        
		        /* Exécution d'une requête de lecture */
		        ResultSet   resultat = preparedStatement.executeQuery();


		        /* Récupération des données du résultat de la requête de lecture */
		       if ( resultat.next()) {
//		            String emailUtilisateur = resultat.getString( "email" );
//		            String motDePasseUtilisateur = resultat.getString( "motpasse" );
		            res="success";
		            response.setContentType("text/html");
		    		response.getWriter().write(res);
		        } else
		        {res="echec";
	            response.setContentType("text/html");
	    		response.getWriter().write(res);}
		        } 
		        catch (SQLException e) {
		        System.out.println("Connection Failed! Check output console");
		        e.printStackTrace();
		        return;
		    }

		    if (connection != null) {
		        System.out.println("You made it, take control your database now!");
		    } else {
		        System.out.println("Failed to make connection!");
		    }
	
		}
	}

