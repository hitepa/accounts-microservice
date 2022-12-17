package com.app.bank.loans.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.bank.loans.model.Loans;


@Repository
public interface LoansRepository extends CrudRepository<Loans, Integer> {
	
	public List<Loans> findByCustomerIdOrderByStartDtDesc(int customerId);
	
	

}
