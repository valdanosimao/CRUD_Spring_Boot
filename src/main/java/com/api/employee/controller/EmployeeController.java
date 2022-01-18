package com.api.employee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.api.employee.model.Employee;
import com.api.employee.service.EmployeeService;

import lombok.Getter;
import lombok.Setter;

@Controller
public class EmployeeController {
	
	
	@Getter
	@Setter
	private EmployeeService employeeService;	
	
	public EmployeeController(EmployeeService employeeService) {		
		this.employeeService = employeeService;
	}

	//display list of employee
	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("listEmployees", employeeService.getAllEmployees());
		return "index";
	}
	
	@GetMapping("/showNewEmployeeForm")
	public String showNewEmployeeForm(Model model) {
		//create model attribute to bind form data
		Employee employee = new Employee();
		model.addAttribute("employee",employee);
		return "new_employee";
	}
	
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		//save employee to database
		employeeService.saveEmployee(employee);
		return "redirect:/";		
	}	
	
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable (value = "id") long id, Model model) {
		//get employee from the service
		Employee employee = employeeService.getEmployeeById(id);
		
		//set employee as a model atribute to pre-populate the form
		model.addAttribute("employee", employee);
		return "update_employee";
	}
	
	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable(value = "id") long id) {
		//call delete employee method
		
		this.employeeService.deleteEmployeeById(id);
		return "redirect:/";
	}

}

	
