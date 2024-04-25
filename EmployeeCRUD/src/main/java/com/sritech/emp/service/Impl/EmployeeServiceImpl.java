package com.sritech.emp.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.sritech.emp.entity.Employee;
import com.sritech.emp.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private JpaRepository<Employee, Integer> jpaRepository;


	@Override
	public List<Employee> getAllEmployeeList() {
	
		List<Employee> list = jpaRepository.findAll();

		System.out.println(list);
		
		return list;
	}

	@Override
	public Employee getEmployeeById(Integer id) {
		
		Employee employee = jpaRepository.getById(id);
		
		return employee;
	}

	@Override
	public void saveEmployee(Employee employee) {
		
		jpaRepository.save(employee);
		
	}

	@Override
	public void updateEmployee(Employee employee) {
		
		 jpaRepository.save(employee);
		
		System.out.println("Updated");
		
	}

	@Override
	public void deleteEmployeeById(Integer id) {
		
		jpaRepository.deleteById(id);
		
	}

}
