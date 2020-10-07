package org.ifc.restservices.services;

import java.util.List;
import java.util.Optional;

import org.ifc.restservices.model.Customer;


public interface CustomerService {

	public List<Customer> findAll();
	
	public Optional<Customer> findById(long cusid );
	
	public Customer save(Customer customer);
	
	public void delete(Customer customer);
	
	
	
}
