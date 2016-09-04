package com.oracle.jdbc.exam.entity;

import java.util.List;

public class Customer {
	private int ID;
	private String username;
	private String location;
	private List<Purcase> buy;

	public Customer() {

	}

	public Customer(int iD) {
		super();
		ID = iD;

	}

	public Customer(int iD, String username, String location) {
		super();
		ID = iD;
		this.username = username;
		this.location = location;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public List<Purcase> getBuy() {
		return buy;
	}

	public void setBuy(List<Purcase> buy) {
		this.buy = buy;
	}

	@Override
	public String toString() {
		return "Customer [ID=" + ID + ", username=" + username + ", location=" + location + ", buy=" + buy + "]";
	}


}
