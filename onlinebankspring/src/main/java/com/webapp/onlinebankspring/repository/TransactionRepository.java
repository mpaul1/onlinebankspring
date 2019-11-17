package com.webapp.onlinebankspring.repository;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.webapp.onlinebankspring.model.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

	@Query("Select T From Transaction T where T.toAccount=:accountNumber OR T.fromAccount=:accountNumber")
	ArrayList<Transaction> findByAccountIds(Long accountNumber);
	

//	@Query("Select T From Transaction T where T.toAccount=:accountNumber OR T.fromAccount=:accountNumber")
//	@Query("Select T From Transaction T where T.transactiondate <= :transactionDate AND T.toAccount=:accountNumber OR T.transactiondate <= :transactionDate AND T.fromAccount=:accountNumber")
	
	@Query("Select T From Transaction T where T.transactiondate <= :transactionDate AND (T.toAccount=:accountNumber OR T.fromAccount=:accountNumber)")
	ArrayList<Transaction> findByAccountIdsWithin30Days(Long accountNumber, Date transactionDate);
	

	
}
 

