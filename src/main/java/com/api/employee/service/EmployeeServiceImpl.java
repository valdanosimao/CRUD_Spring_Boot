package com.api.employee.service;

import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.stereotype.Service;

import com.api.employee.model.Employee;
import com.api.employee.repository.EmployeeRepository;

import lombok.Getter;
import lombok.Setter;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Getter
	@Setter
	private EmployeeRepository employeeRepository;	

	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {		
		this.employeeRepository = employeeRepository;
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public void saveEmployee(Employee employee) {
		this.employeeRepository.save(employee);
		
	}

	@Override
	public Employee getEmployeeById(long id) {
		Optional<Employee> optional = employeeRepository.findById(id);
		Employee employee = null;
		if(optional.isPresent()) {
			employee = optional.get();
		}else {
			throw new RuntimeErrorException(null, "Employee not found for id :: " + id);
		}
		return employee;
	}

	@Override
	public void deleteEmployeeById(long id) {
		this.employeeRepository.deleteById(id);
		
	}

}
