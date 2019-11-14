package com.webapp.onlinebankspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webapp.onlinebankspring.model.*;





public interface CustomerRepository extends JpaRepository<Customer, Long>
{

	Customer findByEmail(String email);
}
