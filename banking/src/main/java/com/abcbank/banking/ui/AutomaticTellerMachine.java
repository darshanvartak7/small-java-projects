package com.abcbank.banking.ui;

import java.text.NumberFormat;
import java.util.Scanner;

import com.abcbank.banking.exceptions.AccountException;
import com.abcbank.banking.service.AccountService;
import com.abcbank.banking.service.AccountServiceImpl;

public class AutomaticTellerMachine {
	
	private static AccountService accountService = new AccountServiceImpl(); 
	
	
	public static void main( String[] args ){
		
		Scanner scanner = new Scanner(System.in);  
		int option = 9999;
		int counter = 0; 
		int customerId=0;
		int customerPIN=0;
		System.out.println("Welcome to ABC Bank");
		boolean validCustomer = false;
		boolean validPIN = false;
		NumberFormat formatter =  NumberFormat.getCurrencyInstance();
		
		   	
		System.out.println("Please enter your customer id to get started");
		
		while(true) {
			customerId=0;
			
			if(scanner.hasNextInt()) {
				customerId = scanner.nextInt();
			}
			else {
				scanner.next();
			}
	    	
	    	if(!accountService.validateAccount(customerId)) {
	    		System.out.println("Please enter valid customer id");	
	    	}
	    	else {
	    		validCustomer = true;
	    		accountService.loadAccountDetails(customerId);
	    		break;
	    	}
		}	
		
		
		
		System.out.println("Please enter your PIN");
		
		while(true) {
			customerPIN=0;
			
	    	if(counter >= 3) {
	    		System.out.println("You have exceeded maximum attempts to enter a valid PIN. Please contact helpdesk @ (111) 111 1111");
	    		break;
	    	}
	    	
			if(scanner.hasNextInt()) {
				customerPIN = scanner.nextInt();
			}
			else {
				scanner.next();
			}
	    	
	    	if(!accountService.validatePIN(customerId, customerPIN)) {
	    		System.out.println("Please enter valid PIN");	
	    		counter++;
	    	}
	    	else {
	    		validPIN = true;
	    		break;
	    	}
		}
		
		if(validCustomer && validPIN) {
	    	
	    	System.out.println("Select one of the following options");
	    	
	    	System.out.println("1. Check Balanace");
	    	System.out.println("2. Deposit");
	    	System.out.println("3. Withdraw");
	    	System.out.println("4. Exit");
	    	
	    	
	    	
	    	do {
	    		option = 9999;
	    		System.out.println("Enter your option");
	    		
	    		if(scanner.hasNextInt()) {
	    			option = scanner.nextInt();
	    		}
	    		else {
	    			scanner.next();
	    		}
	    		
		    	switch (option) {
		    	
		    	case 1 :
		    		//Show Balance
		    		System.out.println("Current account balance is " + formatter.format(accountService.getBalance()));
		    		break;
		    		
		    	case 2 :
		    		//Deposit
		    		System.out.println("Please enter amount to deposit");
		    		double depositAmount = 0.0;
		    		if(scanner.hasNextDouble()) {
		    			depositAmount = scanner.nextDouble();
		    			
			    		try {
							accountService.deposit(depositAmount);
							System.out.println("Deposit of "+ formatter.format(depositAmount) +" successful. New balance is " + formatter.format(accountService.getBalance()));
						} catch (AccountException e) {
							System.out.println(e.getMessage());
						}
		    		}
		    		else {
		    			System.out.println("Please enter valid amount");
		    			scanner.next();
		    		}
		    		
		    		break;
		    		
		    	case 3 :
		    		//Withdraw
		    		System.out.println("Please enter amount to withdraw");
		    		
		    		double withdrawAmount = 0;
		    		if(scanner.hasNextDouble()) {
		    			withdrawAmount = scanner.nextDouble();
		    			
			    		try {
							accountService.withdraw(withdrawAmount);
							System.out.println("Withdrawal of " + formatter.format(withdrawAmount) +" successful. New balance is " + formatter.format(accountService.getBalance()));
						} catch (AccountException e) {
							System.out.println(e.getMessage());
						}
		    		}
		    		else {
		    			System.out.println("Please enter valid amount");
		    			scanner.next();
		    		}
		    		
		    		break;
		    	case 4 :
		    		//Exit
		    		System.out.println("Thanks for banking with ABC Bank. You have logged out successfully");
		    		break;	
		    	default :
		    		// Invalid option 
		    		System.out.println("Invalid option. Please select appropriate option");
		    		break;	
		    		
		    	}
	    	} while(option != 4);
		}
		
		scanner.close();
	}
    
    
}



