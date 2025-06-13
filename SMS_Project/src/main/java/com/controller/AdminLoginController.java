package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bo.Admin;
import com.dao.JDBCDao;

/**
 * Servlet implementation class AdminLoginController
 */
@WebServlet("/AdminLoginController")
public class AdminLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLoginController() {
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
		String adminUsername = request.getParameter("adminUsername");
		String adminPassword = request.getParameter("adminPassword");
		
		ResultSet rs = JDBCDao.viewAdmin();
		try {
		    boolean authentication = false;

		    while (rs.next()) {
		        if (
		            adminPasskey != null && adminUsername != null && adminPassword != null &&
		            adminPasskey.equals(rs.getString(1)) &&
		            adminUsername.equals(rs.getString(4)) &&
		            adminPassword.equals(rs.getString(5))
		        ) {
		            authentication = true;
		            break;
		        }
		    }

		    if (authentication) {
		    	Admin admin = new Admin( 
		    			rs.getString("passkey"),
		    			rs.getString("name"),
		    			rs.getString("email"),
		    			rs.getString("username"),
		    			rs.getString("password")
		    			);
		    	
		    	request.getSession().setAttribute("adminDetails", admin); // ✅ Save admin info in session

		        pw.println("<html><body style='text-align:center; font-family:sans-serif;'>");
		        pw.println("<h2 style='color:green;'>Login Successful!</h2>");
		        pw.println("<p>Redirecting to Dashboard...</p>");
		        pw.println("<script>");
		        pw.println("setTimeout(function(){ window.location.href = 'dashboard.html'; }, 3000);");
		        pw.println("</script>");
		        pw.println("</body></html>");
		    } else {
		        pw.println("<html><body style='text-align:center; font-family:sans-serif;'>");
		        pw.println("<h2 style='color:red;'>Authentication Failed!</h2>");
		        pw.println("<p>Please check your credentials and try again.</p>");
		        pw.println("<p>Redirecting to Login Page...</p>");
		        pw.println("<script>");
		        pw.println("setTimeout(function(){ window.location.href = 'adminlogin.html'; }, 5000);");
		        pw.println("</script>");
		        pw.println("</body></html>");
		    }
		} catch (Exception e) {
		    e.printStackTrace();  // Use this instead of just printing to console
		}		
	}

}
