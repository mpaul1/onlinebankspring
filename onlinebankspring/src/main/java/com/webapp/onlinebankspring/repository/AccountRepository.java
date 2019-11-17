package com.webapp.onlinebankspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.webapp.onlinebankspring.model.*;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{

	@Query("Select A From Account A where A.accountNumber=:accountNumber")
	Account findbyAccountNumber(Long accountNumber);
}
