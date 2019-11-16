package com.webapp.onlinebankspring.service;

import java.util.Optional;

import com.webapp.onlinebankspring.model.Account;
import com.webapp.onlinebankspring.model.AccountType;
import com.webapp.onlinebankspring.model.Customer;
import com.webapp.onlinebankspring.model.Transaction;
import com.webapp.onlinebankspring.repository.AccountRepository;
import com.webapp.onlinebankspring.repository.CustomerRepository;
import com.webapp.onlinebankspring.repository.TransactionRepository;

public class TransferManager
{
	
	public static String Transfer(CustomerRepository customerRepository, AccountRepository accountRepository, TransactionRepository transactionRepository, Customer c, Account s, Customer c2, Account d, Long value,
			String externalTransferDetails)
	{
		Customer housedepositcustomer = customerRepository.findByEmail("1@e.c");
		Optional<Account> housedepositaccount= accountRepository.findById(2L);

		Transaction t = new Transaction(c.getPersonId(), s.getAccountNumber(), c2.getPersonId(), d.getAccountNumber(), value, externalTransferDetails);
		String transferStatus = "";

		if(s.getAccountType()==AccountType.House) {
			
			s.RemoveFunds(value);
			d.AddFunds(value);
			accountRepository.save(s);
			transactionRepository.save(t);
			accountRepository.save(d);
			transferStatus = "success";
		}else {
			
			if(c.getOverdraftProtect()==false) {
				if (s.getAccountBalance() - value > 0) {
					
					s.RemoveFunds(value);
					d.AddFunds(value);
					accountRepository.save(s);
					transactionRepository.save(t);
					accountRepository.save(d);
					transferStatus = "success";
				}else if (s.getAccountBalance() - value > -500) {
					
					s.RemoveFunds(value);
					d.AddFunds(value);
					accountRepository.save(s);
					transactionRepository.save(t);
					accountRepository.save(d);
					
					Transaction t2 = new Transaction(c.getPersonId(), s.getAccountNumber(), housedepositcustomer.getPersonId(), housedepositaccount.get().getAccountNumber(),c.getTransactionFee(), "Overdraft Fee");
					s.RemoveFunds(c.getTransactionFee());
					d.AddFunds(c.getTransactionFee());
					accountRepository.save(s);
					transactionRepository.save(t);
					accountRepository.save(d);
					transferStatus = "success";
				}else {
					transferStatus = "failed";
				}
			}else {
				if (s.getAccountBalance() - value > -500) {
					
					s.RemoveFunds(value);
					d.AddFunds(value);
					accountRepository.save(s);
					transactionRepository.save(t);
					accountRepository.save(d);
					transferStatus = "success";
				}else {
					transferStatus = "failed";
				}
				
			}
		}
	



	return transferStatus;
}

}
