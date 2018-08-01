package com.mindtree.employeemanagement.entity;

import java.util.Collection;

public class ResponseDetails {

	private String status;
	private String message;
	private String statusCode;

	Collection<Employee> employees;

	public ResponseDetails(String status, String message, String statusCode, Collection<Employee> employees) {
		super();
		this.status = status;
		this.message = message;
		this.statusCode = statusCode;
		this.employees = employees;
	}

	public String getStatus() {
		return status;
	}

	public String getMessage() {
		return message;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public Collection<Employee> getEmployees() {
		return employees;
	}

}
