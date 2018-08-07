package com.cg.spring.PaymentWalletSpring.dto;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CustomersSpring {
	@Id
	private String number;
	private String name;
	private Double balance;
	private String transaction;

	public CustomersSpring() {
		// TODO Auto-generated constructor stub
	}

	public CustomersSpring(String number, String name, Double balance, String transaction) {
		super();
		this.number = number;
		this.name = name;
		this.balance = balance;
		this.transaction = transaction;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public String getTransaction() {
		return transaction;
	}

	public void setTransaction(String transaction) {
		this.transaction = transaction;
	}

	
}
