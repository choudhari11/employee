package com.example.EmployeeDataManagement.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="department",schema = "public")
public class department {
	
	private int id;
    private String departmentname;
    /*@OneToOne(mappedBy = "Employee")
    private employee Employee;*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
	public int getId() {
		return id;
	}
    @Column(name="department_name")
	public String getDepartmentname() {
		return departmentname;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setDepartmentname(String departmentname) {
		this.departmentname = departmentname;
	}
	
	/*public employee getEmployee() {
		return Employee;
	}
	public void setEmployee(employee employee) {
		Employee = employee;
	}*/
	
	

}
