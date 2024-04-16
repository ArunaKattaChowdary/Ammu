package com.sritech.emp.DAOImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.sritech.emp.DAO.EmployeeDAO;
import com.sritech.emp.Model.Employee;
import com.sritech.emp.Model.EmployeeMapper;

public class EmployeeDAOImpl implements EmployeeDAO{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Employee> getAllEmployeesList() {
		
		List<Employee> list = jdbcTemplate.query("SELECT * FROM EMP", new EmployeeMapper());
		System.out.println(list);
		
		return list;	
	}

	@Override
	public int addEmployeeRecord(Employee employee) {
		
		int count = jdbcTemplate.update("INSERT INTO EMP(Name,Job,Sal,DeptName,Age,Gender) VALUES(?,?,?,?,?,?)", employee.getEmpName(),employee.getEmpJob(),employee.getEmpSal(),employee.getEmpDName(),employee.getEmpAge(),employee.getEmpGender());
		
		return count;
	}

	@Override
	public Employee getEmployeeById(int empId) {
		
		List<Employee> list = jdbcTemplate.query("SELECT * FROM EMP WHERE Id =?", new EmployeeMapper(),empId);
		
		
		Employee employee = list.get(0);
		
		return employee;
	}

	@Override
	public int updateEmployee(Employee employee) {
			
		int count = jdbcTemplate.update("UPDATE EMP SET Name=?,Job=?,Sal=?,DeptName=?,Age=?,Gender=? WHERE Id=?",employee.getEmpName(),employee.getEmpJob(),employee.getEmpSal(),employee.getEmpDName(),employee.getEmpAge(),employee.getEmpGender(),employee.getEmpId());
			
		return count;
	}

	
	@Override
	public int deleteEmployeeRecord(int employeeid) {

		int count = jdbcTemplate.update("DELETE FROM EMP WHERE Id=?",employeeid);
		
		return count;
	}

	

}

