package com.app.bank.accounts.service.client;

import com.app.bank.accounts.model.Customer;
import com.app.bank.accounts.model.Loans;
import org.springframework.beans.factory.annotation.CustomAutowireConfigurer;
import org.springframework.beans.factory.annotation.CustomAutowireConfigurer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient("loans")
public interface LoansFeignClient {
    @RequestMapping(method= RequestMethod.POST, value="myLoans", consumes = "application/json")
    List<Loans> getLoansDetails(@RequestBody Customer customer);
}
