package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bo.Admin;
import com.bo.Student;

public class JDBCDao {

	public static Connection getConnection() {
		Connection con = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/SMS", "root", "Sam@246");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return con;
	}

	public static int insertAdmin(Admin a1) {
		int status = 0;
		
		try {
			Connection con = JDBCDao.getConnection();
			PreparedStatement ps = con.prepareStatement("insert into admin values(?,?,?,?,?)");
			
			ps.setString(1, a1.getAdminPasskey());
			ps.setString(2, a1.getAdminName());
			ps.setString(3, a1.getAdminEmail());
			ps.setString(4, a1.getAdminUsername());
			ps.setString(5, a1.getAdminPassword());
			
			status = ps.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
		return status;
	}
	
	public static ResultSet viewAdmin() {
		ResultSet rs = null;
		try {
			Connection con = JDBCDao.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from admin");
			
			rs = ps.executeQuery();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
		return rs;
	}
	
	public static int insertStudent(Student s1) {
		int status = 0;
		
		try {
			Connection con = JDBCDao.getConnection();
			PreparedStatement ps = con.prepareStatement("insert into student values(?,?,?,?)");
			
			ps.setString(1, s1.getName());
			ps.setString(2, s1.getAge());
			ps.setString(3, s1.getStudentClass());
			ps.setString(4, s1.getCity());
			
			status = ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return status;
	}
	
	public static List<Student> viewStudents() {
	    List<Student> list = new ArrayList<>();
	    try {
	    	Connection con = getConnection();
	    	Statement stmt = con.createStatement();
	        ResultSet rs = stmt.executeQuery("select * from student"); 
	        while (rs.next()) {
	            Student s = new Student();
	            s.setName(rs.getString("name"));
	            s.setAge(rs.getString("age"));
	            s.setStudentClass(rs.getString("studentclass"));
	            s.setCity(rs.getString("city"));
	            list.add(s);
	        }
	        con.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return list;
	}
	
	public static Student getStudentByName(String name) {
	    Student s = new Student();
	    try {
	        Connection con = getConnection();
	        PreparedStatement ps = con.prepareStatement("select * from student where name=?");
	        ps.setString(1, name);
	        ResultSet rs = ps.executeQuery();
	        if (rs.next()) {
	            s.setName(rs.getString("name"));
	            s.setAge(rs.getString("age"));
	            s.setStudentClass(rs.getString("studentClass"));
	            s.setCity(rs.getString("city"));
	        }
	        con.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return s;
	}

	public static int updateStudent(Student s, String originalName) {
	    int status = 0;
	    try {
	        Connection con = getConnection();
	        PreparedStatement ps = con.prepareStatement("update student set name=?, age=?, studentClass=?, city=? where name=?");
	        ps.setString(1, s.getName());
	        ps.setString(2, s.getAge());
	        ps.setString(3, s.getStudentClass());
	        ps.setString(4, s.getCity());
	        ps.setString(5, originalName);
	        status = ps.executeUpdate();
	        con.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return status;
	}

	public static int deleteStudent(String name) {
	    int status = 0;
	    try {
	        Connection con = getConnection();
	        PreparedStatement ps = con.prepareStatement("delete from student where name=?");
	        ps.setString(1, name);
	        status = ps.executeUpdate();
	        con.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return status;
	}
}
