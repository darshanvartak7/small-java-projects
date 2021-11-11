package com.abcbank.banking.service;

import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class AccountValidationTest {

	private static AccountService accountService;
	
	@BeforeClass
	public static void setUp() {
		accountService = new AccountServiceImpl();
	}
	
	@Test
	public void validateAccount() {
		assertTrue(accountService.validateAccount(1234l));
	}
}
