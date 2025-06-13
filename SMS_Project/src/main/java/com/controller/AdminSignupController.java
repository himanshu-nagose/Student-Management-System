package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bo.Admin;
import com.dao.JDBCDao;

/**
 * Servlet implementation class AdminSignupController
 */
@WebServlet("/AdminSignupController")
public class AdminSignupController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminSignupController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		String adminPasskey = request.getParameter("adminPasskey");
		String adminName = request.getParameter("adminName");
		String adminEmail = request.getParameter("adminEmail");
		String adminUsername = request.getParameter("adminUsername");
		String adminPassword = request.getParameter("adminPassword");
		
		Admin a1 = new Admin(adminPasskey, adminName, adminEmail, adminUsername, adminPassword);
		
		int status = JDBCDao.insertAdmin(a1);
		if (status > 0) {
		    pw.println("<html><body style='text-align:center; font-family:sans-serif;'>");
		    pw.println("<h2 style='color:green;'>Signup Successful!</h2>");
		    pw.println("<p>You will be redirected to the login page shortly...</p>");
		    pw.println("<script>");
		    pw.println("setTimeout(function(){ window.location.href = 'index.html'; }, 3000);");
		    pw.println("</script>");
		    pw.println("</body></html>");
		} else {
		    pw.println("<html><body style='text-align:center; font-family:sans-serif;'>");
		    pw.println("<h2 style='color:red;'>Something went wrong!</h2>");
		    pw.println("</body></html>");
		}		
	}

}
