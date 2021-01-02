 package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import  javax.servlet.http.*;

	@WebServlet("/Reponse1")
	public class Reponse1 extends HttpServlet {
		private static final long serialVersionUID = 1L;
	 
		public Reponse1() {super();}
	 
		@Override
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String res;
			String mail = request.getParameter("mail").trim();
			String motPasse = request.getParameter("motPasse").trim();
	 
	 
			if(mail == null || "".equals(mail) || motPasse == null || "".equals(motPasse)){
				res = "fail";
			}
	 
			if(mail.equals("l@gmail.com") && motPasse.equals("007")) 
			{
			
				
				res="success"
				;response.setContentType("text/html");
				response.getWriter().write(res);

			
			} else {res="fail";response.setContentType("text/html");
			response.getWriter().write(res);}
	 
			
		}
	 
	}

