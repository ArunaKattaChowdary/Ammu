package com.sritech.emp.DAO.Impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import com.sritech.emp.DAO.EmployeeDAO;
import com.sritech.emp.model.Employee;

public class EmployeeDAOImpl implements EmployeeDAO{

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Employee> getEmployee() {
		
		System.out.println("enter into dao layer");
		
		 Session session = sessionFactory.openSession();
		
		 Query <Employee>query = session.createQuery("FROM Employee ");
		
		 List<Employee> list = query.list();

		
		return list;
	}

	@Override
	public Employee getEmployeesById(int empId) {
		
		Session session = sessionFactory.openSession();
		
		Query <Employee> query = session.createQuery("From Employee Where Id = :id");
		
		query.setParameter("id", empId);
		
		List<Employee> list = query.list();
		
		Employee employee = list.get(0);
		
		return employee;
	}

	@Override
	public void addEmployee(Employee employee) {
		
		 Session session = sessionFactory.openSession();
        
		session.save(employee);
		 
		Transaction transaction = session.beginTransaction();
	
		transaction.commit();
		System.out.println(employee);
	
	}
	
	@Override
	public int updateEmployee(Employee employee) {
		
		Session session = sessionFactory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		String hql = "update Employee set Name = :name,  Job = :job, Sal = :salary, DeptName = :dept, Age = :age, Gender= :gender where Id = :id";
		
		Query<Employee> query = session.createQuery(hql);
		
		query.setParameter("name", employee.getEmpName());
		
		query.setParameter("job", employee.getEmpJob());
		
		query.setParameter("salary", employee.getEmpSal());
		
		query.setParameter("dept", employee.getEmpDName());
		
		query.setParameter("age", employee.getEmpAge());
		
		query.setParameter("gender", employee.getEmpGender());
		
		query.setParameter("id", employee.getEmpId());
		
		int count = query.executeUpdate();
		
		transaction.commit(); 
		
		System.out.println("Successfully Updated");
		
		return  count;

	}
	
	@Override
	public int deleteEmployee(int empId) {
		Session session = sessionFactory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		Query <Employee> query = session.createQuery("delete From Employee Where Id = :id");
		
		query.setParameter("id", empId);
		
		int count = query.executeUpdate();
		
		transaction.commit();
		
		System.out.println("Successfully Deleted");
		
		return count;
	}
	
	
	
}
