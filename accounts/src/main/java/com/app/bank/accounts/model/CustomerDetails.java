package com.app.bank.accounts.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;


@Getter
@Setter
@ToString
public class CustomerDetails {

    private Account account;
    private List<Cards> cards;
    private List<Loans> loans;
}
