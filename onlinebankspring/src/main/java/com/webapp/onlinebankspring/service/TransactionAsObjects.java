package com.webapp.onlinebankspring.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;

import com.webapp.onlinebankspring.model.*;
import com.webapp.onlinebankspring.repository.AccountRepository;
import com.webapp.onlinebankspring.repository.CustomerRepository;
import com.webapp.onlinebankspring.repository.TransactionRepository;

public class TransactionAsObjects
{
	
	private Date transactiondate;
	private Customer toCustomer;
	private Account toAccount;
	private Customer fromCustomer;
	private Account fromAccount;
	private long amount;
	private String externalTransferDetails;
	
	public TransactionAsObjects() {
		
	}
	
	public TransactionAsObjects(Customer toCustomer, Account toAccount, Customer fromCustomer,
			Account fromAccount, long amount, String externalTransferDetails)
	{
		super();
		this.toCustomer = toCustomer;
		this.toAccount = toAccount;
		this.fromCustomer = fromCustomer;
		this.fromAccount = fromAccount;
		this.amount = amount;
		this.transactiondate = new Date();
		this.externalTransferDetails=  externalTransferDetails;
	}
	
	public TransactionAsObjects(Date date, Customer toCustomer, Account toAccount, Customer fromCustomer,
			Account fromAccount, long amount, String externalTransferDetails)
	{
		super();
		this.toCustomer = toCustomer;
		this.toAccount = toAccount;
		this.fromCustomer = fromCustomer;
		this.fromAccount = fromAccount;
		this.amount = amount;
		this.transactiondate=date;
		this.externalTransferDetails=  externalTransferDetails;
	}

	public Date getTransactiondate()
	{
		return transactiondate;
	}

	public void setTransactiondate(Date transactiondate)
	{
		this.transactiondate = transactiondate;
	}

	public Customer getToCustomer()
	{
		return toCustomer;
	}

	public void setToCustomer(Customer toCustomer)
	{
		this.toCustomer = toCustomer;
	}

	public Account getToAccount()
	{
		return toAccount;
	}

	public void setToAccount(Account toAccount)
	{
		this.toAccount = toAccount;
	}

	public Customer getFromCustomer()
	{
		return fromCustomer;
	}

	public void setFromCustomer(Customer fromCustomer)
	{
		this.fromCustomer = fromCustomer;
	}

	public Account getFromAccount()
	{
		return fromAccount;
	}

	public void setFromAccount(Account fromAccount)
	{
		this.fromAccount = fromAccount;
	}

	public long getAmount()
	{
		return amount;
	}

	public void setAmount(long amount)
	{
		this.amount = amount;
	}

	public String getExternalTransferDetails()
	{
		return externalTransferDetails;
	}

	public void setExternalTransferDetails(String externalTransferDetails)
	{
		this.externalTransferDetails = externalTransferDetails;
	}
	
	public static ArrayList<TransactionAsObjects> transactionsAsObjects(CustomerRepository customerRepository, 
			AccountRepository accountRepository, TransactionRepository transactionRepository, String accountnumber)
	{
		ArrayList<Transaction> accountTransactions = new ArrayList<Transaction>();
		accountTransactions = transactionRepository.findByAccountIds(Long.parseLong(accountnumber));
		
		ArrayList<TransactionAsObjects> transactionAsObjectArrayList = new ArrayList<TransactionAsObjects>();
		for (int i = 0; i < accountTransactions.size(); i++) {
			Date tdate = accountTransactions.get(i).getTransactiondate();
			Long amount = accountTransactions.get(i).getAmount();
			String externalTransferDetails = accountTransactions.get(i).getExternalTransferDetails();
			Customer toCustomer = customerRepository.findByPersonId(accountTransactions.get(i).getToCustomer());
			Account toAccount = accountRepository.findbyAccountNumber(accountTransactions.get(i).getToAccount());
			Customer fromCustomer = customerRepository.findByPersonId(accountTransactions.get(i).getFromCustomer());
			Account fromAccount = accountRepository.findbyAccountNumber(accountTransactions.get(i).getFromAccount());

			
			TransactionAsObjects transaction = new TransactionAsObjects(tdate, toCustomer, toAccount, fromCustomer,
					fromAccount, amount, externalTransferDetails);
			transactionAsObjectArrayList.add(transaction);
		}
		
		
		return transactionAsObjectArrayList;
				
	}
	

	public static Comparator<Transaction> tDateComparator = new Comparator<Transaction>() {         
	    @Override         
	    public int compare(Transaction t1, Transaction t2) {             
	      return (t2.getTransactiondate().before(t1.getTransactiondate()) ? -1 :                     
	              (t2.getTransactiondate().equals(t1.getTransactiondate()) ? 0 : 1));           
	    }     
	  };  

	@Override
	public String toString()
	{
		SimpleDateFormat f=new SimpleDateFormat("MMM dd yyyy HH:mm:ss");
		return f.format(transactiondate)+","+toCustomer+","+toAccount+","
				+fromCustomer+","+fromAccount+","+amount+","+externalTransferDetails;
		
	}
	
	
}
