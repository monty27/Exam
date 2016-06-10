package com.monty.exam.dao;

public class Customer {
	private int id;
	private String name;
	private String address;
	private int ssn;
	private String username;
	private String password;
	
	public Customer(int id, String name, String address, int ssn, String username, String password) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.ssn = ssn;
		this.username = username;
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getSsn() {
		return ssn;
	}
	public void setSsn(int ssn) {
		this.ssn = ssn;
	}

}
