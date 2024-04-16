package com.sritech.emp.Model;

public class Employee {
	
	private Integer empId;
	
	private String empName;
	
	private String empJob;
	
	private double empSal;
	
	private String empDName;
	
	private Integer empAge;
	
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

	public double getEmpSal() {
		return empSal;
	}

	public void setEmpSal(double empSal) {
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
