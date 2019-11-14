package com.webapp.onlinebankspring.model;

import javax.persistence.Entity;

@Entity
public class HouseAccount extends Account
{
	protected AccountType accountType = AccountType.House;
	
	
	
	public HouseAccount() {
		super();
	}



	public HouseAccount(long accountBalance)
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
		return "Account:"+accountNumber+","+this.getAccountType()+","+Long.toString(accountBalance);
		
	}



}
