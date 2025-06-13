package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bo.Student;
import com.dao.JDBCDao;

/**
 * Servlet implementation class AddStudentController
 */
@WebServlet("/AddStudentController")
public class AddStudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStudentController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String studentClass = request.getParameter("studentClass");
		String city = request.getParameter("city");
		
		Student s1 = new Student(name, age, studentClass, city);
		
		int status = JDBCDao.insertStudent(s1);
		if(status > 0) {
		    response.getWriter().println("<html><body style='text-align:center; font-family:sans-serif;'>");
		    response.getWriter().println("<h2 style='color:green;'>Student Record Added Successfully!</h2>");
		    response.getWriter().println("<p>Redirecting to Dashboard...</p>");
		    response.getWriter().println("<script>");
		    response.getWriter().println("setTimeout(function(){ window.location.href = 'dashboard.html'; }, 3000);");
		    response.getWriter().println("</script>");
		    response.getWriter().println("</body></html>");
		} else {
		    response.getWriter().println("<html><body style='text-align:center; font-family:sans-serif;'>");
		    response.getWriter().println("<h2 style='color:red;'>Failed to Add Student Record!</h2>");
		    response.getWriter().println("<p>Please try again later.</p>");
		    response.getWriter().println("</body></html>");
		}
	}

}
