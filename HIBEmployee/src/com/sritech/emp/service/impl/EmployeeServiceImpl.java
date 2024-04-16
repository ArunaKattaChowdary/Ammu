package com.sritech.emp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.sritech.emp.DAO.EmployeeDAO;
import com.sritech.emp.model.Employee;
import com.sritech.emp.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeDAO employeeDAO;

	@Override
	public List<Employee> getEmployee() {

         System.out.println("enter into service layer");
         
         List<Employee> list = employeeDAO.getEmployee();
		return list;
	}

	@Override
	public Employee getEmployeesById(int empId) {

		Employee employee = employeeDAO.getEmployeesById(empId);
		
		return employee;
	}



	

	@Override
	public int updateEmployee(Employee employee) {
			
		int count = employeeDAO.updateEmployee(employee);
		
		return count;
	}

	@Override
	public int deleteEmployee(int empId) {
		
		int count = employeeDAO.deleteEmployee(empId);
		
		return count;
	}

	@Override
	public void addEmployee(Employee employee) {
		
		 employeeDAO.addEmployee(employee);
		
		
	}
	

}
