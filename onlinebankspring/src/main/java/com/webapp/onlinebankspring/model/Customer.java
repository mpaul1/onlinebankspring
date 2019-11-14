package com.webapp.onlinebankspring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;


@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class Customer extends Person  
{
	
//	@Id 
//	@GeneratedValue(strategy=GenerationType.AUTO)
//	protected long customerId;
//	ArrayList<Account> accounts;
	private boolean overdraftProtection = false;
	private int transactionFee = 30;

	public Customer()
	{
		super();
	}

	public Customer(String firstName, String lastName, String telephoneNumber, String email,
			String password, String street, String city, String state, String zipCode)
	{
		super(firstName, lastName, telephoneNumber, email, password, street, city, state, zipCode);
//		this.accounts = new ArrayList<Account>();
//		this.personid = (Bank.personidCounter);
//		Bank.personidCounter = (this.personid+ 1);
		
	}
	
//	public Customer(int personid, String firstName, String lastName, String telephoneNumber, String email,
//			String password,boolean overdraftProtection, String street, String city, String state, String zipCode)
//	{
//		super(firstName, lastName, telephoneNumber, email, password, street, city, state, zipCode);
////		this.accounts = new ArrayList<Account>();
////		this.personid = (personid);
////		Bank.personidCounter = (this.personid+ 1);
//		this.overdraftProtection = overdraftProtection;
//		
//	}

//	public ArrayList<Account> getAccounts()
//	{
//		return accounts;
//	}
//
//	public void setAccounts(ArrayList<Account> accounts)
//	{
//		this.accounts = accounts;
//	}
	
//	public long getCustomerId() {
//		return customerId;
//	}
//
//	public void setCustomerId(long customerId) {
//		this.customerId = customerId;
//	}

//	public boolean isOverdraftProtection() {
//		return overdraftProtection;
//	}

	public boolean getOverdraftProtect() {
		
		return overdraftProtection;
	}
	
	public void setOverdraftProtection(boolean overdraftProtection) {
		this.overdraftProtection = overdraftProtection;
	}

	public int getTransactionFee()
	{
		return transactionFee;
	}

	public void setTransactionFee(int transactionFee)
	{
		this.transactionFee = transactionFee;
	}

//	public void addAccountToAccounts(Account account)
//	{
//		accounts.add(account);
//	}
	
	public String getFullName() {
		return firstName+" "+lastName;
	}
	
//	public String PrintAccounts()
//	{
//		String stringAccounts=":AccountsSplit:";
//		for(Account account:accounts)
//		{
//			stringAccounts += account.toString();
//			
//		}
//		return stringAccounts;
//	}

//	@Override
//	public String toString()
//	{
//		return personid+","+firstName+","+lastName+","+telephoneNumber+","+email+","+password+","+overdraftProtection+","+address.toString()+","+PrintAccounts();
//		
//	}

	@Override
	public String toString()
	{
		return personId+","+firstName+","+lastName+","+telephoneNumber+","+email+","+password+","+overdraftProtection+","+street+","+city+","+state+","+zipCode;

	}

	
	
}
