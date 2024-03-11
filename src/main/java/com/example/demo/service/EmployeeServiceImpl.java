package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

	@Override
	public void save(Employee theEmployee) {
		employeeRepository.save(theEmployee);
		
	}

	@Override
	public Employee findById(int id) {
		// TODO Auto-generated method stub
		Optional<Employee> employeeById =  employeeRepository.findById(id);
		Employee employee = employeeById.get();
		return employee;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		Optional<Employee> employees = employeeRepository.findById(id);
		Employee employee = employees.get();
		employeeRepository.delete(employee);
		
	}

	
}
