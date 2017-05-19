package com.suseel.webStore.domain;

public class Customer {
	private int customerId;
	private String name;
	private String address;
	private int noOfOrdersMade;
	
	public Customer(){
		super();
	}
	
	public Customer(int customerId, String name, String address) {
		super();
		this.address = address;
		this.name = name;
		this.customerId = customerId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
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

	public int getNoOfOrdersMade() {
		return noOfOrdersMade;
	}

	public void setNoOfOrdersMade(int noOfOrdersMade) {
		this.noOfOrdersMade = noOfOrdersMade;
	}

}
