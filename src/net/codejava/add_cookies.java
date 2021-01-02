package net.codejava;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class add_cookies
 */
@WebServlet("/add_cookies")
public class add_cookies extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static int cookieCount;
     
    public add_cookies() {
    }
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
        String name = "Cookie" + (++cookieCount);
        String value = String.valueOf(System.currentTimeMillis());
        Cookie cookie = new Cookie(name, value);       
         
        response.addCookie(cookie);
         
        response.getWriter().println("A cookie has been created successfully!");
         
    }
 
}
