package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.Employee;

public interface EmployeeService {

	List<Employee> findAll();

	void save(Employee theEmployee);
	
	Employee findById(int id);

	void delete(int id);

}
