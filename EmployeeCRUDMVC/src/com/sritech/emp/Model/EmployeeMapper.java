package com.sritech.emp.Model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class EmployeeMapper implements RowMapper<Employee>{

	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Employee employee = new Employee();
		
		employee.setEmpId(rs.getInt(1));
		employee.setEmpName(rs.getString(2));
		employee.setEmpJob(rs.getString(3));
		employee.setEmpSal(rs.getDouble(4));
		employee.setEmpDName(rs.getString(5));
		employee.setEmpAge(rs.getInt(6));
		employee.setEmpGender(rs.getString(7));
		
		return employee;
	}

	

	
}
