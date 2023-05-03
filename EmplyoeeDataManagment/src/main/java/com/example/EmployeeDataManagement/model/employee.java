package com.example.EmployeeDataManagement.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;


@Entity
@Table(name="Employee" ,schema="public")
public class employee {
	
	   private int id;
	   private String name;
	   private String address;
	   private String gender;
	   private Long contact;
	   private int departentid;
	/*   @OneToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name = "dept_id", referencedColumnName = "id")
	   private department Department;
	   @OneToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name = "address_id", referencedColumnName = "id")
	   private address  Address;*/
	   
	   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	@Column(name="department_id") 
	public int getDepartentid() {
		return departentid;
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
	public void setDepartentid(int departentid) {
		this.departentid = departentid;
	}
/*	public department getDepartment() {
		return Department;
	}
	public void setDepartment(department department) {
		Department = department;
	}
	public void setAddress(address address) {
		Address = address;
	}*/
	
	
	
	
	
	
	
	
	   

}
