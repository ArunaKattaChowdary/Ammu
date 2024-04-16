package com.sritech.emp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.sritech.emp.DAO.EmployeeDAO;
import com.sritech.emp.Model.Employee;
import com.sritech.emp.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeDAO employeeDAO;

	@Override
	public List<Employee> getAllEmployeesList() {
		
		List<Employee> list = employeeDAO.getAllEmployeesList();
		
		return list;
	}

	@Override
	public int addEmployeeRecord(Employee employee) {
		
		int count = employeeDAO.addEmployeeRecord(employee);
		
		return count;
	}



	@Override
	public Employee getEmployeeById(int empId) {
		
		Employee employee = employeeDAO.getEmployeeById(empId);
		
		return employee;
		
	}

	@Override
	public int updateEmployeeRecord(Employee employee) {
		
		int count = employeeDAO.updateEmployee(employee);
		
		return count;
	}

	

	@Override
	public int deleteEmployeeRecord(int employeeid) {
		int count = employeeDAO.deleteEmployeeRecord(employeeid);
		return 0;
	}

	
	


}
