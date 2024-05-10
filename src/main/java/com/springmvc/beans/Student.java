package com.springmvc.beans;  
  
public class Student {
    private int id;
    private String name;
    private String email;
    private int number;
    private String address;
    
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getAddress() {
        return address;
    }
	 public void setAddress(String address) {
	        this.address = address;
	    }
    
}