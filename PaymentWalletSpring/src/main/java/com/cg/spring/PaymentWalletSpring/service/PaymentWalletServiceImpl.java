package com.cg.spring.PaymentWalletSpring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cg.spring.PaymentWalletSpring.dto.CustomersSpring;
import com.cg.spring.PaymentWalletSpring.repo.PaymentWalletRepo;

@Service
public class PaymentWalletServiceImpl implements PaymentWalletService {
	@Autowired
	private PaymentWalletRepo repo;

	@Override
	public void createAccount(CustomersSpring customer) {
		customer.setTransaction("Account Created\n-------------------");
		repo.save(customer);
	}

	@Override
	public double showBalance(String number) {
		return repo.findById(number).get().getBalance();
	}

	@Override
	public void deposit(String number, Double amount) {
		CustomersSpring customer = repo.findById(number).get();
		customer.setBalance(customer.getBalance() + amount);
		customer.setTransaction(customer.getTransaction() + "\n " + amount + " deposited");
		repo.save(customer);
	}

	@Override
	public void withdraw(String number, Double amount) {
		CustomersSpring customer = repo.findById(number).get();
		customer.setBalance(customer.getBalance() - amount);
		customer.setTransaction(customer.getTransaction() + "\n " + amount + " Withdrawn");
		repo.save(customer);
	}

	@Override
	public void fundTransfer(String number1, String number2, Double amount) {
		CustomersSpring customer = repo.findById(number1).get();
		customer.setBalance(customer.getBalance() - amount);
		customer.setTransaction(customer.getTransaction() + "\n " + amount + " Transferred");
		repo.save(customer);
		CustomersSpring customer1 = repo.findById(number2).get();
		customer1.setBalance(customer1.getBalance() + amount);
		customer1.setTransaction(customer1.getTransaction() + "\n " + amount + " Transferred");
		repo.save(customer1);

	}

	@Override
	public String printTransaction(String number) {
		return repo.findById(number).get().getTransaction();
	}

	@Override
	public List<CustomersSpring> getAllCustomers() {
		List<CustomersSpring> list = new ArrayList<>();
		repo.findAll().forEach(list::add);
		return list;
	}

}
