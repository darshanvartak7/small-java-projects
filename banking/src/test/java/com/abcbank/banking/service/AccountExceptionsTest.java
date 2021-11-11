package com.abcbank.banking.service;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.Alphanumeric;
import com.abcbank.banking.exceptions.AccountException;

@TestMethodOrder(Alphanumeric.class)
public class AccountExceptionsTest {
	
	private static AccountService accountService;
	
	@BeforeClass
	public static void setUp() {
		accountService = new AccountServiceImpl(); 
		accountService.loadAccountDetails(9999l);
	}
	
	   
    @Test //validateInvalidAmount
    public void validateA(){
		try {
			accountService.withdraw(-2345);
		} catch (AccountException e) {
			assertTrue(e.getMessage().equals("Please enter valid amount"));
		}
    	
    }
    
    @Test //validateZeroAmount
    public void validateB(){
    	try {
			accountService.withdraw(100);
		} catch (AccountException e) {
			assertTrue(e.getMessage().equals("The account balance is zero"));
		}
    	
    }
    
    @Test //validateInvalidAmount
    public void validateC(){
    	try {
			accountService.deposit(-2345);
		} catch (AccountException e) {
			assertTrue(e.getMessage().equals("Please enter valid amount"));
		}
    	
    }

}
