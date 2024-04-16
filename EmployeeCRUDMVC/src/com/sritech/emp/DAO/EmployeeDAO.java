package com.sritech.emp.DAO;

import java.util.List;

import com.sritech.emp.Model.Employee;

public interface EmployeeDAO {
	
	public List<Employee> getAllEmployeesList();
	
	public  int addEmployeeRecord(Employee employee);

	public Employee getEmployeeById(int empId);

	public int updateEmployee(Employee employee);

	

	public int deleteEmployeeRecord(int employeeid);
	
	
}
