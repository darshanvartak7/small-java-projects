package com.abcbank.banking.service;

import com.abcbank.banking.exceptions.AccountException;

public interface AccountService {
	public boolean validateAccount(long accountId);
	public boolean validatePIN(long customerId, int pin);
	public void loadAccountDetails(long customerId);
	public double getBalance();
	public double deposit(double amount) throws AccountException;
	public double withdraw(double amount) throws AccountException;
}
