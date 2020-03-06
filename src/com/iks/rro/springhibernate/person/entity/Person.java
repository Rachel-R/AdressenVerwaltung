package com.iks.rro.springhibernate.person.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;


@Entity
@Table(name="person")//(name="person") only has to be specified whenever Class and corresponding Table DO NOT have the same name
public class Person {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)//Auto-increment
	@Column(name="id")//(name="id") only has to be specified whenever Variable and corresponding Column DO NOT have the same name
	private int id;
	@Column(name="lastname")
	private String lastname = "";
	@Column(name="firstname")
	private String firstname = "";
	@Column(name="address")
	private String address = "";
	@Column(name="phone")
	private String phone = "";

	public Person() {
		
	}

	public Person(int id, String lastname, String firstname, String address, String phone) {
		this.id = id;
		this.lastname = lastname;
		this.firstname = firstname;
		this.address = address;
		this.phone = phone;
	}

	public Person(String lastname, String firstname, String address, String phone) {
		this.lastname = lastname;
		this.firstname = firstname;
		this.address = address;
		this.phone = phone;
	}

	public String toHTMLString() {
		return "id: " + id + "<br>Lastname: " + lastname + "<br>Firstname: " 
				+ firstname + "<br>Address: " + address + "<br>Phone: " + phone;
	}
	
	public String toRegularString() {
		return "\nid: " + id + "\nLastname: " + lastname + "\nFirstname: " 
				+ firstname + "\nAddress: " + address + "\nPhone: " + phone;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}
