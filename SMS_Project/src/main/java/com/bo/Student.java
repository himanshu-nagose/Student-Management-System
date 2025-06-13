package com.bo;

public class Student {
	private String name;
	private String age;
	private String studentClass;
	private String city;
	
	public Student() {
		
	}
	
	public Student(String name, String age, String studentClass, String city) {
		super();
		this.name = name;
		this.age = age;
		this.studentClass = studentClass;
		this.city = city;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getStudentClass() {
		return studentClass;
	}
	public void setStudentClass(String studentClass) {
		this.studentClass = studentClass;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}	
}
