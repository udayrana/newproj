package com.mindtree.employeemanagement.service;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.mindtree.employeemanagement.entity.Employee;
import com.mindtree.employeemanagement.repository.EmployeeManagementRepository;

@Service(value = "EmployeeManagementServices")
@CacheConfig
public class EmployeeManagementServiceImpl implements EmployeeManagementServices {

	@Autowired
	EmployeeManagementRepository employeeManagementRepository;

	@Override
	@Cacheable("employee.all")
	public Collection<Employee> findAll() {
		Collection<Employee> employees = employeeManagementRepository.findAll();
		return employees;
	}

	@Override
	@Cacheable("employee.byId")
	public Employee findOne(Long id) {
		System.out.println("getById for employee caches  is created");
		Employee employee = employeeManagementRepository.findById(id).get();

		return employee;
	}

	@Override
	public Employee create(Employee employee) {
		Employee employeeTemp;
		System.out.println("looping going to create 1000 entry of employee");
		for (int i = 1; i < 10000; i++) {
			System.out.println("looping going to create 1000 entry of employee" + i);

			employeeTemp = new Employee();
			employeeTemp.setDateOfBirth(employee.getDateOfBirth());
			employeeTemp.setFullName(employee.getFullName() + i);
			employeeTemp.setUserName(employee.getUserName() + i);
			employeeTemp.setEmailId(employee.getEmailId() + i);
			employeeTemp.setGender(employee.getGender());
			employeeTemp.setPassword(employee.getPassword() + 1);
			employeeTemp.setSecurityAnswer(employee.getSecurityAnswer());
			employeeTemp.setSecurityQuestion(employee.getSecurityQuestion());
			employeeManagementRepository.save(employeeTemp);

		}
		System.out.println("looping going to create 1000 entry of employee and it's complited");
		return employee;
	}

	@Override
	@Transactional
	public boolean delete(Long empId) {
		employeeManagementRepository.deleteById(empId);
		return true;
	}

	@Override
	public Employee checkLogin(String userName, String password) {

		Employee employee = employeeManagementRepository.findEmployeeByUserNameAndPassword(userName, password);
		return employee;

	}

}
