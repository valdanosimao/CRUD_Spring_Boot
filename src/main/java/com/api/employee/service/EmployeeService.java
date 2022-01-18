package com.api.employee.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.api.employee.model.Employee;

@Service
public interface EmployeeService {
	List<Employee> getAllEmployees();
	void saveEmployee(Employee employee);
	Employee getEmployeeById(long id);
	void deleteEmployeeById(long id);
	
}
