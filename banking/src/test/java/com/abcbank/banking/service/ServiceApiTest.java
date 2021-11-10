package com.abcbank.banking.service;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer.Alphanumeric;
import org.junit.jupiter.api.TestMethodOrder;
import com.abcbank.banking.exceptions.AccountException;

@TestMethodOrder(Alphanumeric.class)
public class ServiceApiTest 
{
	private static AccountService accountService;
	
	@BeforeClass
	public static void setUp() {
		accountService = new AccountServiceImpl(); 
		accountService.loadAccountDetails(1234l);
	}

    @Test //validatePIN 
    public void validateA(){
    	assertTrue(accountService.validatePIN(1234l, 5656));
    }
    
    @Test //validateBalance 
    public void validateB(){
    	assertTrue(accountService.getBalance() == 10000.60);
    }
    
    @Test //validateDeposit
    public void validateC(){
    	try {
			accountService.deposit(100);
		} catch (AccountException e) {
			e.printStackTrace();
		}
    	assertTrue(accountService.getBalance() == 10100.60);
    }
    
    @Test //validateWithdrawal
    public void validateD(){
    	try {
			accountService.withdraw(100);
		} catch (AccountException e) {
			e.printStackTrace();
		}
    	assertTrue(accountService.getBalance() == 10000.60);
    }
 
    @Test //validateInvalidAmount
    public void validateE(){
    	try {
			accountService.withdraw(150000);
		} catch (AccountException e) {
			assertTrue(e.getMessage().equals("The account does not have sufficient balance"));
		}
    	
    }
    
    
    
    
}
