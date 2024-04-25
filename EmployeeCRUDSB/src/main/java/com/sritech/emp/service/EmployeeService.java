package com.sritech.emp.service;

import java.util.List;

import com.sritech.emp.entity.Employee;

public interface EmployeeService {

	public List<Employee> getAllEmployeeList();
	
	public Employee getEmployeeById(Integer id);
	
	public void saveEmployee(Employee employee);
	
	public void updateEmployee(Employee employee);
	
	public void deleteEmployeeById(Integer id);

	
}
