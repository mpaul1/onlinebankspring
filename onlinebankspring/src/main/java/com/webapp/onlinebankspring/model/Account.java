package com.webapp.onlinebankspring.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
public abstract class Account implements ITransferSource, ITransferDestination
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected long accountNumber;
	protected AccountType accountType;
	protected long accountBalance = 0;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="personId")
	protected Person person;

	public Account() {
		super();
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	
	public long getAccountNumber()
	{
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber)
	{
		this.accountNumber = accountNumber;
	}

	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	public long getAccountBalance()
	{
		return accountBalance;
	}

	public void setAccountBalance(long accountBalance)
	{
		this.accountBalance = accountBalance;
	}

	@Override
	public void AddFunds(long value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void RemoveFunds(long value) {
		// TODO Auto-generated method stub
		
	}
//	@Override
//	public int hashCode() {
//		return new HashCodeBuilder().append(accountNumber).toHashCode();
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if(!(obj instanceof Account)) return false;
//		Account other = (Account) obj;
//		return new EqualsBuilder().append(accountNumber, other.accountNumber).isEquals();
//	}

	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", accountType=" + ", accountBalance="
				+ accountBalance + ", person=" + person + "]";
	}






	
	
	
//	public String createMonthlyStatement(String month, int year, Account account, Customer customer, Bank bank)
//	{
//
//		String path = "C:\\Users\\mpaul\\Documents\\eclipse-workspace\\FileStorage\\streams\\" + customer.getEmail()
//				+ "-" + month + "-" + year + "-" + "Statement.txt";
////		PrintWriter out=null;
//		try (PrintWriter out = new PrintWriter(path))
//		{
//
//			out.print("                                    Monthly Statement\n");
//			out.print(
//					"----------------------------------------------------------------------------------------------------\n");
//			out.print(customer.getFullName() + "                                             Bank of Everyone\n");
//			out.print(customer.getAddress().getStreet() + "                                  1520 Washington Ave\n");
//			out.print(customer.getAddress().getCity() + " ," + customer.getAddress().getState() + ", "
//					+ customer.getAddress().getZipCode()
//					+ "                                    St. Louis, MO, 63101\n");
//			out.print("\n\n");
//			out.print("Account: " + account.getAccountNumber() + "\n");
//			out.print("\n\n");
//			out.print("Account Balance: " + account.getAccountBalance() + "\n");
//			out.print("\n\n");
//			out.print("                    Account Transaction Details for " + month + " " + year + "\n");
//			out.print("\n\n");
//			for (Transaction t : bank.getTransactions())
//			{
//				if (account.getAccountNumber() == t.getFromAccount().getAccountNumber()
//						|| account.getAccountNumber() == t.getToAccount().getAccountNumber())
//				{
//					long tamount = 0;
//					String description = (t.getExternalTransferDetails().equalsIgnoreCase("x")) ? ""
//							: t.getExternalTransferDetails();
//					if (t.getFromAccount().getAccountNumber() == 2
//							|| t.getToAccount().getAccountNumber() == account.getAccountNumber())
//					{
//						tamount = -t.getAmount();
//					} else
//					{
//						tamount = t.getAmount();
//					}
//					out.print(t.getTransactiondate() + ", " + t.getToCustomer().getFullName() + ", "
//							+ t.getToAccount().getAccountNumber() + ", " + t.getFromCustomer().getFullName() + ", "
//							+ t.getFromAccount().getAccountNumber() + ", " + tamount + ", " + description + "\n");
//				}
//			}
//
//		} catch (FileNotFoundException e)
//		{
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return path;
//	}
//	
//	public String createMonthlyStatement(ArrayList<Transaction> transactions, String month, String year, Customer customer, Account account)
//	{
//
//		String path = "C:\\Users\\mpaul\\Documents\\eclipse-workspace\\FileStorage\\streams\\" + customer.getEmail()
//				+ "-" + month + "-" + year + "-" + "Statement.txt";
////		PrintWriter out=null;
//		SimpleDateFormat fmonth=new SimpleDateFormat("MMM");
//		SimpleDateFormat fyear=new SimpleDateFormat("yyyy");
//		try (PrintWriter out = new PrintWriter(path))
//		{
//
//			out.print("                                    Monthly Statement\n");
//			out.print(
//					"----------------------------------------------------------------------------------------------------\n");
//			out.print(customer.getFullName() + "                                             Bank of Everyone\n");
//			out.print(customer.getAddress().getStreet() + "                                  1520 Washington Ave\n");
//			out.print(customer.getAddress().getCity() + " ," + customer.getAddress().getState() + ", "
//					+ customer.getAddress().getZipCode()
//					+ "                                    St. Louis, MO, 63101\n");
//			out.print("\n\n");
//			out.print("Account: " + account.getAccountNumber() + "\n");
//			out.print("\n\n");
//			out.print("Account Balance: " + account.getAccountBalance() + "\n");
//			out.print("\n\n");
//			out.print("                    Account Transaction Details for " + month + " " + year + "\n");
//			out.print("\n\n");
//			for (Transaction t : transactions)
//			{
//				String tmonth = fmonth.format(t.getTransactiondate());
//				String tyear = fyear.format(t.getTransactiondate());
//				if (tmonth.equalsIgnoreCase(month)&&tyear.equalsIgnoreCase(year))
//				{
//					long tamount = 0;
//					String description = (t.getExternalTransferDetails().equalsIgnoreCase("x")) ? ""
//							: t.getExternalTransferDetails();
//					if (t.getFromAccount().getAccountNumber() == 2
//							|| t.getToAccount().getAccountNumber() == account.getAccountNumber())
//					{
//						tamount = -t.getAmount();
//					} else
//					{
//						tamount = t.getAmount();
//					}
//					out.print(t.getTransactiondate() + ", " + t.getToCustomer().getFullName() + ", "
//							+ t.getToAccount().getAccountNumber() + ", " + t.getFromCustomer().getFullName() + ", "
//							+ t.getFromAccount().getAccountNumber() + ", " + tamount + ", " + description + "\n");
//				}
//			}
//
//		} catch (FileNotFoundException e)
//		{
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return path;
//	}
}
