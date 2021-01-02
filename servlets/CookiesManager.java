package com.servlets;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class CookiesManager
 */
@WebServlet("/CookiesManager")
public class CookiesManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CookiesManager() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	
		 Cookie[] cookies = request.getCookies();
	        if (cookies != null) {
	            for (Cookie cookie : cookies) {
	                if (cookie.getName().equals("prenom")) {
	                    request.setAttribute("prenom", cookie.getValue());
	                }
	            }
	        }
	        this.getServletContext().getRequestDispatcher("/bienvenue.jsp").forward(request, response);
	}

	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        
        Cookie cookie = new Cookie("prenom", prenom);
        cookie.setMaxAge(60 * 60 * 24 * 30);
        response.addCookie(cookie);
        
        this.getServletContext().getRequestDispatcher("/bienvenue.jsp").forward(request, response);
    }
	

}
