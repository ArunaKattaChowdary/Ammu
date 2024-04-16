package com.sritech.emp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="emp")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id")
	private Integer empId;
	@Column(name="Name")
	private String empName;
	@Column(name="Job")
	private String empJob;
	@Column(name="Sal")
	private Double empSal;
	@Column(name="DeptName")
	private String empDName;
	@Column(name="Age")
	private Integer empAge;
	@Column(name="Gender")
	private String empGender;
	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpJob() {
		return empJob;
	}
	public void setEmpJob(String empJob) {
		this.empJob = empJob;
	}
	public Double getEmpSal() {
		return empSal;
	}
	public void setEmpSal(Double empSal) {
		this.empSal = empSal;
	}
	public String getEmpDName() {
		return empDName;
	}
	public void setEmpDName(String empDName) {
		this.empDName = empDName;
	}
	public Integer getEmpAge() {
		return empAge;
	}
	public void setEmpAge(Integer empAge) {
		this.empAge = empAge;
	}
	public String getEmpGender() {
		return empGender;
	}
	public void setEmpGender(String empGender) {
		this.empGender = empGender;
	}
	@Override
	public String toString() {
		return empId + "," + empName + "," + empJob + "," + empSal + "," + empDName + "," + empAge + "," + empGender;
	}

}
