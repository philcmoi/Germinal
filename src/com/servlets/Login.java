package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import codage.Cryptage;

/**
 * Servlet implementation class Traitement
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	
		Connection connection = null ;
        try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/germinal?serverTimezone=UTC","root","L099339RWFH");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	
		String token = ((Double)(Math.random() * 10000)).toString();
		token = Cryptage.crypter(token,"valeur");
		
		Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("token")) {
                	token = cookie.getValue();
        			try {
						PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM membre WHERE token= ?");
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                }
           }          
	}
}
			

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
//			Class.forName("com.mysql.jdbc.Driver");

		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			System.out.println("mysql cj");
			e1.printStackTrace();
		}
		
		
		    Boolean connectable = false;

			ResultSet resultat = null;
			Connection connection = null  ;
			
			String message = null,name = null,value = null;
			
			Cookie cookie = null;
						
			try {
				String rememberme = request.getParameter("rememberme");

				
				PrintWriter writer = response.getWriter();
		         
		        Cookie[] cookies = request.getCookies();
		         
		        if (cookies == null) {
		        	System.out.println("No cookies found");
		        	message = "EMAIL OU MOT DE PASSE INCONNUS";
					 request.setAttribute("text", message);
     request.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		        } else {
		        	System.out.println("Number of cookies: " + cookies.length);
		             
		            for (Cookie cookie1 : cookies) {
		                 name = cookie1.getName();
		                 value = cookie1.getValue();
		                 System.out.println(value);
		                 if (name.equals("cookieGerminal")) {break;}
		                
		            }
		            
		            if (rememberme == null)
		            {Cookie[] cookies1 = request.getCookies();
		            
		            if (cookies1 != null) {
		                for (Cookie aCookie : cookies1) {
		                    aCookie.setMaxAge(0);
		                    response.addCookie(aCookie);
		                }
		                
		                value = null;
		                
//		                System.out.println("All cookies have been deleted!");
//		                message = "EMAIL OU MOT DE PASSE INCONNUS";
//						 request.setAttribute("text", message);
//	     request.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		            } else {
//		            	System.out.println("No cookies found");
//		            	message = "EMAIL OU MOT DE PASSE INCONNUS";
//						 request.setAttribute("text", message);
//	     request.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		            }
		            }
		            
//		            if (rememberme == null) {
		             String email = value;
		             System.out.println("value email ="+value);
		 			
		             connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/germinal?serverTimezone=UTC","root","L099339RWFH");

		             PreparedStatement  preparedStatement = null;
		    		
		             email = Cryptage.crypter(email,"valeur");
		             
					preparedStatement = connection.prepareStatement("SELECT * FROM membre WHERE email= ?");
					preparedStatement.setString(1,email);
					
					resultat = preparedStatement.executeQuery();
//					resultat.getObject("pseudo");
					
					if (resultat.next() && connectable) {
						message = "super bien jouet " + resultat.getObject("pseudo") +" " +value;
						request.setAttribute("text", message);
						System.out.println("bien jouet");
						request.getServletContext().getRequestDispatcher("/bienvenue.jsp").forward(request, response);
					}
//		            }***********
					else {
						
											
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/germinal?serverTimezone=UTC","root","L099339RWFH");

				
		
				email = request.getParameter("email");
				String motpasse = request.getParameter("password");
				rememberme = request.getParameter("rememberme");
				
				motpasse = Cryptage.crypter(motpasse,"valeur");
				email = Cryptage.crypter(email,"valeur");
			
				
			preparedStatement = null;
		
			preparedStatement = connection.prepareStatement("SELECT * FROM membre WHERE email= ? and motpasse= ?");
			preparedStatement.setString(1,email);
			preparedStatement.setString(2,motpasse);
			
			resultat = preparedStatement.executeQuery();
			
				if ( resultat.next()) {
					
					System.out.println("email et mot de passe correct");
					
					if (rememberme != null) {
						
						name = "cookieGerminal";
				        value = Cryptage.decrypter(email, "valeur");
				        System.out.println(value);
				        cookie = new Cookie(name, value);    
						cookie.setMaxAge(60 * 60 * 24 * 30);
				        response.addCookie(cookie);
				        
						String pseudo= resultat.getObject("pseudo").toString();
						connectable = true;
						
				        message = pseudo + " = " + value;
						request.setAttribute("text", message);
						request.getServletContext().getRequestDispatcher("/bienvenue.jsp").forward(request, response);	
					
					}
					
					else {
//						Cookie[] cookies = request.getCookies();
				         
					
					 String message2 = "bienvenue " + Cryptage.decrypter(email,"valeur");
					 message = message2 + "   " + name + " = " + " VALEUR COOKIE " + value;
					request.setAttribute("text", message);
					request.getServletContext().getRequestDispatcher("/bienvenue.jsp").forward(request, response);

				}
				}
				
			 else  {
				    System.out.println("echec de connection avec mot de passe et email");    

					  message = "EMAIL OU MOT DE PASSE INCONNUS";
					 request.setAttribute("text", message);
      request.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
					}
			
//		        ***********************************************************
				
				
//					connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/germinal?serverTimezone=UTC","root","L099339RWFH");
	 
					}
					
		        
		        }
			} catch (SQLException | ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}	                
}

