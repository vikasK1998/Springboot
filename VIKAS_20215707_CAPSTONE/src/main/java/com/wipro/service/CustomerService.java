package com.wipro.service;

import java.util.List;
import java.util.Optional;

import com.wipro.Model.Customer;

public interface CustomerService {
	
	public Customer addCustomer(Customer cus);
	
	public List<Customer> findAll();
	
	public Optional<Customer> getCustomerById(long id);
	
	public String deleteCustomerById(long id);
	
	public void deleteAllCustomer();

	Customer UpdateCustomerById(Customer customer);

}
