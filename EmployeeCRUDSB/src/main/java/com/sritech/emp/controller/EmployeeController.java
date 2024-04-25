package com.sritech.emp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sritech.emp.entity.Employee;
import com.sritech.emp.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/")
	public ModelAndView showEmployeeList(ModelAndView model)
	{
	
		List<Employee> employeeList = employeeService.getAllEmployeeList();
		
		model.addObject("employeeList", employeeList);
		
		model.setViewName("EmployeeList");
		
		return model;
	}
	
	@GetMapping("/newEmployee")
	public ModelAndView showEmployeeForm(ModelAndView model)
	{
	
		model.setViewName("EmployeeForm");
		
		return model;
	}
	@PostMapping("/addEmployee")
	public String saveEmployee(@RequestParam String name, @RequestParam String job, @RequestParam String sal, @RequestParam String dept, @RequestParam String age, @RequestParam String gender)
	{
		
		Employee employee = new Employee();
		
		employee.setEmpName(name);
		
		employee.setEmpJob(job);
		
		employee.setEmpSal(Double.parseDouble(sal));
		
		employee.setEmpDeptName(dept);
		
		employee.setEmpAge(Integer.parseInt(age));
		
		employee.setEmpGender(gender);
		
		employeeService.saveEmployee(employee);
		
		return "redirect:/";
	}

	@GetMapping("/editEmployee")
	public ModelAndView showEmployeeEditForm(ModelAndView model, @RequestParam String employeeid)
	{
		
		Employee employee = employeeService.getEmployeeById( Integer.parseInt(employeeid));
		
		model.addObject("emp", employee);
		
		model.setViewName("EditForm");
		
		return model ;
	}

	@PostMapping("/updateEmployee")
	public String updateEmployee(@RequestParam String id,@RequestParam String name, @RequestParam String job, @RequestParam String sal, @RequestParam String dept, @RequestParam String age, @RequestParam String gender)
	{
		Employee employee = new Employee();
		
		employee.setEmpId(Integer.parseInt(id));
		employee.setEmpName(name);
		employee.setEmpJob(job);
		employee.setEmpSal(Double.parseDouble(sal));
		employee.setEmpDeptName(dept);
		employee.setEmpAge(Integer.parseInt(age));
		employee.setEmpGender(gender);
		
		employeeService.updateEmployee(employee);
		
		return "redirect:/";
	}
	
	@GetMapping("/deleteEmployee")
	public String deleteById(@RequestParam String employeeid)
	{
		employeeService.deleteEmployeeById(Integer.parseInt(employeeid));
		
		return "redirect:/";
	}
}
