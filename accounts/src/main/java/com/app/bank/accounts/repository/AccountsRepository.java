package com.app.bank.accounts.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.bank.accounts.model.Account;

@Repository
public interface AccountsRepository extends CrudRepository<Account, Long> {

	Account findByCustomerId(int customerId);
	
}
