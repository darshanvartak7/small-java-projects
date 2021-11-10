package com.abcbank.banking.model;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Repository {
	
	Map<Long,Account>  accounts;
	
	public Repository(){
		   accounts = new ConcurrentHashMap<Long,Account>();
		   
		   Account account = new Account(1234l,10000.60d,"John Smith","Checking",5656);
		   accounts.put(1234l, account);
		   
		   account = new Account(9999l,0.0d,"Lucy Mills","Checking",4545);
		   accounts.put(9999l, account);
	}

	
	public Account fetchAccountInfo(long customerId) {
		return accounts.get(customerId);
	}
	
	public boolean validateAccount(long customerId) {
		return accounts.containsKey(customerId);
	}
	
	public boolean validatePIN(long customerId, int pin) {
		return (((Account)accounts.get(customerId)).getPin() == pin);
	}

}

