package com.mindtree.employeemanagement.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.employeemanagement.entity.Employee;
import com.mindtree.employeemanagement.entity.ResponseDetails;
import com.mindtree.employeemanagement.service.EmployeeManagementServices;

@RestController
@RequestMapping("/EmpMgt")
public class EmployeeManagementController {
	@Autowired
	public EmployeeManagementServices employeeManagementServices;

	@RequestMapping(value = "/getAllEmpDetails", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseDetails getAllEmpDetails() {
		System.out.println("==Hello==");
		try {
			Collection<Employee> employees = employeeManagementServices.findAll();

			if (!employees.isEmpty()) {
				return new ResponseDetails("Success ", "Success ", "200", employees);

			} else {
				return new ResponseDetails("failure", "No Employee found", "200", employees);
			}
		}

		catch (Exception e) {
			return new ResponseDetails("failure", "Exception while fetching recore from db", "400", null);
		}

	}

	@RequestMapping(value = "/getByEmpId/{empId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseDetails getByEmpId(@PathVariable("empId") Long empId) {
		Collection<Employee> employees = new LinkedList<Employee>();
		try {
			Employee employee = employeeManagementServices.findOne(empId);
			if (employee != null) {
				employees.add(employee);
				return new ResponseDetails("Success ", "[]", "200 ", employees);
			} else {
				return new ResponseDetails("failure", "Input data mismatch", "400", employees);
			}

		} catch (Exception e) {
			return new ResponseDetails("failure", "There is some issue at server side. Please check the log", "500",
					employees);
		}

	}

	@RequestMapping(value = "/addEmp", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseDetails addEmp(@RequestBody Employee employee) {
		Collection<Employee> employees = new LinkedList<Employee>();
		try {
			employeeManagementServices.create(employee);
			return new ResponseDetails("Success ", "Employee data inserted successfully", "200 ", employees);

		} catch (Exception e) {
			return new ResponseDetails("failure", "Input data not inserted", "400", employees);
		}

	}

	@RequestMapping(value = "/checkLogin", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseDetails checkLogin(@RequestBody Employee employee) {
		Collection<Employee> employees = new ArrayList<Employee>();
		String userName = employee.getUserName();
		String password = employee.getPassword();
		Employee findEmployee = null;
		findEmployee = employeeManagementServices.checkLogin(userName, password);
		if (findEmployee != null) {
			employees.add(findEmployee);
			return new ResponseDetails("Success", "Employee has authenticated successfully", "200", employees);
		} else {
			return new ResponseDetails("Success", "Invalid Username and Password", "302", employees);

		}
	}

	@RequestMapping(value = "/deleteEmp/{empId}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseDetails deleteEmp(@PathVariable("empId") Long id) {
		try {
			boolean action = employeeManagementServices.delete(id);
			if (action)
				return new ResponseDetails("Success", "Employee data deleted successfully", "200", null);
			else
				return new ResponseDetails("failure", "Input data mismatch emp data not deleted", "400", null);

		} catch (Exception e) {
			return new ResponseDetails("failure", "Input data mismatch", "400", null);
		}

	}
}
