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
 * Servlet implementation class UpdateStudentFinalController
 */
@WebServlet("/UpdateStudentFinalController")
public class UpdateStudentFinalController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateStudentFinalController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String originalName = request.getParameter("originalName");
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String studentClass = request.getParameter("studentClass");
		String city = request.getParameter("city");

		Student s = new Student(name, age, studentClass, city);
		JDBCDao.updateStudent(s, originalName);

		response.sendRedirect("ViewStudentController");
	}

}
