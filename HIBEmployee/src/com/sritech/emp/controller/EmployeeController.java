package com.sritech.emp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sritech.emp.model.Employee;
import com.sritech.emp.service.EmployeeService;

@Controller
public class EmployeeController {
	
	
	@Autowired
	  private EmployeeService employeeService;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView getEmployee(ModelAndView model){
		
		System.out.println("enter into controller");
		
		List<Employee> list = employeeService.getEmployee();
		
		System.out.println(list);
		
		model.addObject("employeesList",list);
		
		model.setViewName("EmployeesList");
		
		return model;
		
		
	}
	
	
	@RequestMapping(value="/newEmployee", method=RequestMethod.GET)
	public ModelAndView newEmployeeForm(ModelAndView model){
	
		model.setViewName("EmployeeForm");
		
		return model;
		
		
	}
	
	@RequestMapping(value = "/editEmployee", method = RequestMethod.GET)
	public ModelAndView showEditEmployee(ModelAndView model,@RequestParam String employeeid){
		
		Employee employee = employeeService.getEmployeesById(Integer.parseInt(employeeid));
		
		model.addObject("emp", employee);
		
		model.setViewName("EditForm");
	
		return model;
		
	}
	
	@RequestMapping(value = "/updateEmployee", method = RequestMethod.POST)
	public String updateEmployee(@RequestParam String id,@RequestParam String name,@RequestParam String job,@RequestParam String salary,@RequestParam String dept,@RequestParam String age,@RequestParam String gender){
		
		Employee employee = new Employee();
		
		employee.setEmpId(Integer.parseInt(id));
		
		employee.setEmpName(name);

		employee.setEmpJob(job);
		
		employee.setEmpSal(Double.parseDouble(salary));
		
		employee.setEmpDName(dept);
		
		employee.setEmpAge(Integer.parseInt(age));
		
		employee.setEmpGender(gender);
		
		System.out.println(employee);
		
		employeeService.updateEmployee(employee);
		
		System.out.println("updated");
	
		return "redirect:/";
		
	}
	
	@RequestMapping(value = "/deleteEmployee", method = RequestMethod.GET)
	public String deleteEmployee(@RequestParam String employeeid){
		
		employeeService.deleteEmployee(Integer.parseInt(employeeid));
		
		System.out.println("deleted");
	
		return "redirect:/";
		
	}
	
	@RequestMapping(value="/addEmployee", method=RequestMethod.POST)
	public String addEmployee(@RequestParam String name, String job, String salary, String dept,String age,String gender){
		Employee employee = new Employee();
		System.out.println("entered into add em[ployee method");
		
		employee.setEmpName(name);
		
		employee.setEmpJob(job);
		
		employee.setEmpSal(Double.parseDouble(salary));
		
		employee.setEmpDName(dept);
		
		employee.setEmpAge(Integer.parseInt(age));
		
		employee.setEmpGender(gender);
		
		System.out.println(employee);
		System.out.println("Inserted");
		
		 employeeService.addEmployee(employee);
		
		
		
		 System.out.println("return controller");
		
			return "redirect:/";
	
		}
	

}
