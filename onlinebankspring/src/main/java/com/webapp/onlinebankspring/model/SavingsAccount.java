package com.webapp.onlinebankspring.model;

import javax.persistence.Entity;

@Entity
public class SavingsAccount extends Account
{
	
	


	public SavingsAccount() {
		super();
		this.accountType = AccountType.Savings;
	}


	public SavingsAccount( long accountBalance)
	{
		super();
		this.accountBalance = accountBalance;
		this.accountType = AccountType.Savings;
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
