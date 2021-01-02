package net.codejava;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class delete_cookies
 */
@WebServlet("/delete_cookies")
public class delete_cookies extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public delete_cookies() {
    }
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         
        PrintWriter writer = response.getWriter();
         
        Cookie[] cookies = request.getCookies();
         
        if (cookies != null) {
            for (Cookie aCookie : cookies) {
                aCookie.setMaxAge(0);
                response.addCookie(aCookie);
            }
             
            writer.println("All cookies have been deleted!");
        } else {
            writer.println("No cookies found");
        }
         
    }
 
}