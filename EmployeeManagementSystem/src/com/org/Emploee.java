package com.org;

import java.io.Serializable;
import java.time.LocalDate;

public class Emploee implements Serializable {
	// Emp details : id(string), first name , last name ,
	// dept(enum : RND,HR,SALES,FINANCE,PRODUCTION), joining date(LocalDate),salary

	private String id;
	private String firstName;
	private String lastName;
	private Department dept;
	private LocalDate date;
	private double salary;

	public Emploee(String id, String firstName, String lastName, Department dept, LocalDate date, double salary) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dept = dept;
		this.date = date;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Emploee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", dept=" + dept
				+ ", date=" + date + ", salary=" + salary + "]";
	}

	public String getId() {
		return id;
	}
	

}
