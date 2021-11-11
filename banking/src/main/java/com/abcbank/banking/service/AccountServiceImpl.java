package com.abcbank.banking.service;

import com.abcbank.banking.exceptions.AccountException;
import com.abcbank.banking.model.Account;
import com.abcbank.banking.model.Repository;

public class AccountServiceImpl implements AccountService {
	private Repository repo;
	private Account account;

	public AccountServiceImpl() {
		super();
		this.repo = new Repository();
	}

	@Override
	public boolean validateAccount(long accountId) {
		return repo.validateAccount(accountId);
	}

	@Override
	public boolean validatePIN(long customerId, int pin) {
		return repo.validatePIN(customerId, pin);
	}

	@Override
	public void loadAccountDetails(long customerId) {
		account = repo.fetchAccountInfo(customerId);
	}

	@Override
	public double getBalance() {
		return account.getBalance();
	}

	@Override
	public synchronized double deposit(double amount) throws AccountException {
		if (amount > 0) {
			account.setBalance(account.getBalance() + amount);
		} else {
			throw new AccountException("Please enter valid amount");
		}
		return account.getBalance();
	}

	@Override
	public synchronized double withdraw(double amount) throws AccountException {

		if (amount <= 0) {
			throw new AccountException("Please enter valid amount");
		}

		if (account.getBalance() == 0.0) {
			throw new AccountException("The account balance is zero");
		}

		if (account.getBalance() < amount) {
			throw new AccountException("The account does not have sufficient balance");
		}

		if (amount > 0) {
			account.setBalance(account.getBalance() - amount);
		}

		return account.getBalance();
	}

}
