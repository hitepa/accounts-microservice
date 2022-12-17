package com.app.bank.accounts.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Customer {
	
	@Id
	@Column(name="customer_id")
	private int customerId;
	@Column(name="name")
	private String name;
	@Column(name="mobile_number")
	private String mobileNumber;
	@Column(name="email")
	private String email;
	@Column(name="created_dt")
	private LocalDate createdDt;
	

}
