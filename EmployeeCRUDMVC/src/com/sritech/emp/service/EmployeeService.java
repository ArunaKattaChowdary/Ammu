package com.sritech.emp.service;

import java.util.List;

import com.sritech.emp.Model.Employee;

public interface EmployeeService {
	
	public List<Employee> getAllEmployeesList();
	
	public  int addEmployeeRecord(Employee employee);

	public Employee getEmployeeById(int empId);

	public int updateEmployeeRecord(Employee employee);

	

	public int deleteEmployeeRecord(int employeeid);
	

}
