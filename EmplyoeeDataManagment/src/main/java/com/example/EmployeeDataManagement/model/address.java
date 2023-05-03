package com.example.EmployeeDataManagement.model;

import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
@Entity
@Table(name="Address",schema="public")
public class address {
	
	   private int  id;
	   private String  street1;
	   private String street2;
	   private String  city;
	   private String state;
	 /*  @OneToOne(mappedBy = "Employee")
	   private employee Employee;*/
	@Id 
    @Column(name="id") 
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
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
	public void setId(int id) {
		this.id = id;
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
	/*public employee getEmployee() {
		return Employee;
	}
	public void setEmployee(employee employee) {
		Employee = employee;
	}*/
	
	
	
	
	
	
	
	   
	   

}
