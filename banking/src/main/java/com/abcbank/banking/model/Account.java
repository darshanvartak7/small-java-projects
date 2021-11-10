package com.abcbank.banking.model;

public class Account {
	
	private long customerId;
	private double balance;
	private String customerName;
	private String accountType;
	private int pin;
	
	public Account(long customerId, double balance, String customerName, String accountType, int pin) {
		super();
		this.customerId = customerId;
		this.balance = balance;
		this.customerName = customerName;
		this.accountType = accountType;
		this.pin = pin;
	}

	public long getCustomerId() {
		return customerId;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public String getCustomerName() {
		return customerName;
	}
	
	public String getAccountType() {
		return accountType;
	}
	
	public void setBalance(double balance) {
		this.balance = balance;
	}
		
	public int getPin() {
		return pin;
	}

}
