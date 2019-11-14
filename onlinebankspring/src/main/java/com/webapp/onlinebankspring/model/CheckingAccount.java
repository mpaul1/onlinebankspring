package com.webapp.onlinebankspring.model;

import javax.persistence.Entity;

@Entity
public class CheckingAccount extends Account
{
	
	protected AccountType accountType = AccountType.Checking;


	public CheckingAccount() {
		super();
	}


	public CheckingAccount( long accountBalance)
	{
		super();
		this.accountBalance = accountBalance;
	}
	
	public AccountType getAccountType() {
		return accountType;
	}


	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}
	
	@Override
	public void RemoveFunds(long value)
	{
		accountBalance -= value;
		
	}
	@Override
	public void AddFunds(long value)
	{
		accountBalance += value;
		
	}

	@Override
	public String toString()
	{
		return "Account:"+accountNumber+","+accountType+","+Long.toString(accountBalance);
		
	}



}
