package com.example.EmployeeDataManagement.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="vw_employee_Data",schema="public")
public class VWEmployeeData {
	
	   private int id;
	   private String name;
	   private String address;
	   private String gender;
	   private Long contact;
	   private String  street1;
	   private String street2;
	   private String  city;
	   private String state;
	   private String departmentname;
	   private int deptId;
	   
	@Id
	@Column(name="emp_id")
	public int getId() {
		return id;
	}
	@Column(name="emp_name")
	public String getName() {
		return name;
	}
	@Column(name="address")
	public String getAddress() {
		return address;
	}
	@Column(name="gender")
	public String getGender() {
		return gender;
	}
	@Column(name="contact")
	public Long getContact() {
		return contact;
	}
	@Column(name="street1")
	public String getStreet1() {
		return street1;
	}
	@Column(name="street2")
	public String getStreet2() {
		return street2;
	}
	@Column(name="city")
	public String getCity() {
		return city;
	}
	@Column(name="state")
	public String getState() {
		return state;
	}
	@Column(name="depart_name")
	public String getDepartmentname() {
		return departmentname;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	public void setContact(Long contact) {
		this.contact = contact;
	}
	public void setStreet1(String street1) {
		this.street1 = street1;
	}
	public void setStreet2(String street2) {
		this.street2 = street2;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setState(String state) {
		this.state = state;
	}
	public void setDepartmentname(String departmentname) {
		this.departmentname = departmentname;
	}
	@Column(name="dept_id")
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	
	
	   
	   
}
