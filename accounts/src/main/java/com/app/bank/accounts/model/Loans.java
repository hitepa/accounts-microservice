package com.app.bank.accounts.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@ToString
public class Loans {
    
	@Id
	@Column(name="loan_number")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int loanNumber;
	
	@Column(name="customer_id")
	private int customerId;
	
	@Column(name="start_dt")
	private Date startDt;
	
	@Column(name="loan_type")
	private String loan_Type;
	
	@Column(name="total_loan")
	private int total_Loan;
	
	@Column(name="amount_paid")
	private int amountPaid;
	
	@Column(name="outstanding_amount")
	private int outstandingAmount;
	
	@Column(name="create_dt")
	private String createDt;
	
}
