package com.webapp.onlinebankspring.model;

import javax.persistence.Entity;

@Entity
public class CheckingAccount extends Account
{
	
	


	public CheckingAccount() {
		super();
		this.accountType = AccountType.Checking;
	}


	public CheckingAccount( long accountBalance)
	{
		super();
		this.accountBalance = accountBalance;
		this.accountType = AccountType.Checking;
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
