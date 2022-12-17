package com.app.bank.loans.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.bank.loans.config.LoanServiceConfig;
import com.app.bank.loans.model.Customer;
import com.app.bank.loans.model.Loans;
import com.app.bank.loans.model.Properties;
import com.app.bank.loans.repository.LoansRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

@RestController
public class LoansController {
	
	@Autowired
	private LoansRepository loansRepository;
	
	@Autowired
	private LoanServiceConfig loanConfig;
	
	@PostMapping("/myLoans")
	public List<Loans> getLoanDetails(@RequestBody Customer customer){
		
		List<Loans> loans = loansRepository.findByCustomerIdOrderByStartDtDesc(customer.getCustomerId());
		
		if(loans!=null && !loans.isEmpty()){
			return loans;
		}
		return null;
	}
	
	

	@GetMapping("/loan/properties")
	public String getPropertyDetails() throws JsonProcessingException {
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		Properties properties = new Properties(loanConfig.getMsg(), loanConfig.getBuildVersion(),
				loanConfig.getMailDetails(), loanConfig.getActiveBranches());
		String jsonStr = ow.writeValueAsString(properties);
		return jsonStr;
	} 

}
