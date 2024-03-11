package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.repository.Employee;
import com.example.demo.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	
	@GetMapping("/list")
	public String getAllEmployees(Model model){
		List<Employee> employees = employeeService.findAll();
		model.addAttribute("employees", employees);
		return "employees/employee-list";
	}
	
	@GetMapping("/showEmployeeForm")
	public String showForm(Model model) {
		model.addAttribute("employee", new Employee());
		return "employees/employee-form";
	}
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee theEmployee,Model model) {
		employeeService.save(theEmployee);
		return "redirect:/employees/list";
	}
	
	@GetMapping("/showUpdateForm")
	public String updateForm(@RequestParam int id,Model model) {
		Employee employee = employeeService.findById(id);
		model.addAttribute("employee", employee);
		return "employees/employee-form";
	}
	
	@GetMapping("/Delete")
	public String delete(@RequestParam int id)
	{
		employeeService.delete(id);
		return "redirect:/employees/list";
	}
	
	
	
}
