package com.webapp.onlinebankspring.model;

import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Transaction
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected long transactionId;
	
	private Date transactiondate = new Date();
	
//	@OneToMany(fetch=FetchType.EAGER)
//	@JoinColumn(name="personId")
	private Long toCustomer;
	
//	@OneToMany(fetch=FetchType.EAGER)
//	@JoinColumn(name="accountNumber")
	private Long toAccount;
	
//	@OneToMany(fetch=FetchType.EAGER)
//	@JoinColumn(name="personId")
	private Long fromCustomer;
	
//	@OneToMany(fetch=FetchType.EAGER)
//	@JoinColumn(name="accountNumber")
	private Long fromAccount;
	
	private long amount;
	private String externalTransferDetails;
	
	public Transaction() {
		
	}
	
	public Transaction(Long toCustomer, Long toAccount, Long fromCustomer,
			Long fromAccount, long amount, String externalTransferDetails)
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
	
//	public Transaction(Date date, Customer toCustomer, Account toAccount, Customer fromCustomer,
//			Account fromAccount, long amount, String externalTransferDetails)
//	{
//		super();
//		this.toCustomer = toCustomer;
//		this.toAccount = toAccount;
//		this.fromCustomer = fromCustomer;
//		this.fromAccount = fromAccount;
//		this.amount = amount;
//		this.transactiondate=date;
//		this.externalTransferDetails=  externalTransferDetails;
//	}

	public long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}

	public Date getTransactiondate()
	{
		return transactiondate;
	}

	public void setTransactiondate(Date transactiondate)
	{
		this.transactiondate = transactiondate;
	}

	public Long getToCustomer()
	{
		return toCustomer;
	}

	public void setToCustomer(Long toCustomer)
	{
		this.toCustomer = toCustomer;
	}

	public Long getToAccount()
	{
		return toAccount;
	}

	public void setToAccount(Long toAccount)
	{
		this.toAccount = toAccount;
	}

	public Long getFromCustomer()
	{
		return fromCustomer;
	}

	public void setFromCustomer(Long fromCustomer)
	{
		this.fromCustomer = fromCustomer;
	}

	public Long getFromAccount()
	{
		return fromAccount;
	}

	public void setFromAccount(Long fromAccount)
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
		return f.format(transactiondate)+","+toCustomer+","+toAccount+","+fromCustomer
		+","+fromAccount+","+amount+","+externalTransferDetails;
//		+","+fromAccount.getAccountNumber()   +fromCustomer.getPersonId()
	}
	
	
}
