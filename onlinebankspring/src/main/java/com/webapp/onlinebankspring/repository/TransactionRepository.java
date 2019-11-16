package com.webapp.onlinebankspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webapp.onlinebankspring.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}
