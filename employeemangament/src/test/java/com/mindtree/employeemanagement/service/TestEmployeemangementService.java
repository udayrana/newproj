package com.mindtree.employeemanagement.service;

import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.mindtree.employeemanagement.EmployeemangamentApplicationTest;
import com.mindtree.employeemanagement.entity.Employee;

public class TestEmployeemangementService extends EmployeemangamentApplicationTest {

	@Autowired
	private EmployeeManagementServiceImpl employeeManagementServiceImpl;

	@Test
	public void testFindAll() {

		Collection<Employee> list = employeeManagementServiceImpl.findAll();
		Assert.assertNotNull("failure- expected not null", list);
		// Assert.assertEquals("failure-expected size", 3, list.size());
	}

	@Test
	public void testFindOne() {
		Long id = new Long(1);
		Employee employee = employeeManagementServiceImpl.findOne(id);
		Assert.assertNotNull("failure-expected not null", employee);
		Assert.assertEquals("failure-expected id method", id, employee.getEmpId());

	}

	// @Test
	// public void testFindOneNotFound() {
	// Long id = Long.MAX_VALUE;
	// Employee employee = employeeManagementServiceImpl.findOne(id);
	// Assert.assertNull("failure-expected null", employee);
	//
	// }

	@Test
	@Rollback
	public void testCreat() {
		Employee employee = new Employee();
		employee.setEmpId(4L);
		;
		employee.setEmailId("game@gmail.com");
		employee.setFullName("rupesh m");
		employee.setGender("Male");
		employee.setPassword("gate");
		employee.setSecurityAnswer("m");
		employee.setSecurityAnswer("last name?");
		employee.setUserName("avi");
		employee.setDateOfBirth("1992-02-10");
		Employee createdEmployee = employeeManagementServiceImpl.create(employee);
		Assert.assertNotNull("failure-expected not null", createdEmployee);
		// Assert.assertEquals("failure-expected id attribute not null",
		// createdEmployee.getEmpId());
		// Collection<Employee> list = employeeManagementServiceImpl.findAll();
		// Assert.assertEquals("failure-expected size", 4, list.size());

	}

	@Test
	@Rollback
	public void testDelete() {
		Long id = new Long(3L);
		employeeManagementServiceImpl.delete(id);
		Collection<Employee> list = employeeManagementServiceImpl.findAll();
		Assert.assertEquals("failure-expected size", 3, list.size());
		// Employee deletedEmployee = employeeManagementServiceImpl.findOne(id);
		// Assert.assertNull("failure-expected entity to be deleted",
		// deletedEmployee);

	}

	@Test

	public void testCheckLogin() {
		String userName = "udayrana";
		String password = "gate";
		Employee employee = employeeManagementServiceImpl.checkLogin(userName, password);
		Assert.assertNotNull("failure-expected entity not null", employee);
		Assert.assertEquals("failure-expected attributed username is equal", userName, employee.getUserName());
		Assert.assertEquals("failure-expected attributed password is equal", userName, employee.getUserName());

	}

}
