package com.sritech.emp.service;

import java.util.List;

import com.sritech.emp.model.Employee;

public interface EmployeeService {

	public List<Employee> getEmployee();

	public Employee getEmployeesById(int empId);

	

	public int updateEmployee(Employee employee);

	public int deleteEmployee(int empId);
	
	public void addEmployee(Employee employee);

}
