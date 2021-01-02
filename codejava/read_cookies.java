package net.codejava;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
@WebServlet("/read_cookies")
public class read_cookies extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public read_cookies() {
    }
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
         
        Cookie[] cookies = request.getCookies();
         
        if (cookies == null) {
            writer.println("No cookies found");
        } else {
            writer.println("Number of cookies: " + cookies.length);
             
            for (Cookie aCookie : cookies) {
                String name = aCookie.getName();
                String value = aCookie.getValue();
                 
                writer.println(name + " = " + value);
            }
        }
    }
 
}