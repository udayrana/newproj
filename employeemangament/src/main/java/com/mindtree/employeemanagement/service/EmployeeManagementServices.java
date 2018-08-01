package com.mindtree.employeemanagement.service;

import java.util.Collection;

import com.mindtree.employeemanagement.entity.Employee;

public interface EmployeeManagementServices {

	Collection<Employee> findAll();

	Employee findOne(Long id);

	Employee create(Employee employee);

	Employee checkLogin(String userName, String password);

	boolean delete(Long empId);

}
