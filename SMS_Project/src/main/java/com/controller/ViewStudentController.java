package com.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bo.Student;
import com.dao.JDBCDao;

@WebServlet("/ViewStudentController")
public class ViewStudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ViewStudentController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Student> studentList = JDBCDao.viewStudents();

		if (studentList == null || studentList.isEmpty()) {
			System.out.println("No student records found in database.");
		} 
		
		request.setAttribute("students", studentList);

		RequestDispatcher rd = request.getRequestDispatcher("viewstudent.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
