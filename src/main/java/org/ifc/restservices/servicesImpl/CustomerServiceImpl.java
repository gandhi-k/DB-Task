package org.ifc.restservices.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.ifc.restservices.model.Customer;
import org.ifc.restservices.repository.CustomerRepository;
import org.ifc.restservices.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties.Opaquetoken;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	CustomerRepository customerRepository;
	
	Logger logger = LogManager.getLogger(this.getClass());

	@Override
	public List<Customer> findAll() {
		// TODO Auto-generated method stub
		
		return customerRepository.findAll();
	}

	@Override
	public Optional<Customer> findById(long cusid) {
		// TODO Auto-generated method stub
		return customerRepository.findById(cusid);
	}

	@Override
	public Customer save(Customer customer) {
		// TODO Auto-generated method stub
		return customerRepository.save(customer);
		
	}

	@Override
	public void delete(Customer customer) {
		// TODO Auto-generated method stub
		
		customerRepository.delete(customer);
		
	}
	
	
	

}
