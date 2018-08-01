package com.mindtree.employeemanagement.repository;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.employeemanagement.entity.Employee;

@Repository
public interface EmployeeManagementRepository extends JpaRepository<Employee, Long> {
	Employee findEmployeeByUserNameAndPassword(String userName, String password);
}
