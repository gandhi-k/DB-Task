package org.ifc.restservices.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.ifc.restservices.model.Customer;
import org.ifc.restservices.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kumar 
 *
 * 
 *  
 * 
 * 
 */

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	Logger logger = LogManager.getLogger(this.getClass());
	
	/**
	 * Method to save the customer
	 * 
	 * @Body Customer object
	 * @return standard customer record
	 * 
	 * 
	 */
    
	@PostMapping("/customers")
	public Customer createCustomer(@Valid @RequestBody Customer cus) {
		
		logger.info("Inside the controller method createCustomer---->");
		
		return customerService.save(cus);
		
	}
	
	/**
	 * Method to fetch all customers 
	 * 
	 * 
	 * @return List of customer
	 */
	@GetMapping("/customers")
	public List<Customer> getAllCustomers(){
		
		logger.info("Inside the controller method getAllCustomers----:");
		
		return customerService.findAll();
	}
	
	/**
	 * Method to fetch individual customers by id 
	 * 
	 * 
	 * @return customer with given id
	 */
	@GetMapping("/customers/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable long id){
		logger.info("Inside the controller method getCustomerById----> customer_id :"
				+ id);
		
		Optional<Customer> result=customerService.findById(id);
		Customer customer=null;
		if(result.isPresent()) {
			
			customer=result.get();
		}else {
			
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok().body(customer);
	}
	
	/**
	 * Method to update customer by cus_id 
	 * 
	 * 
	 * @return customer with updated value
	 */
	
	@PutMapping("/customers/{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable long id, @Valid @RequestBody Customer cusdetils){
		logger.info("Inside the controller method updateCustomer----> Customer_Id :"
				+ id);
		
		Optional<Customer> result=customerService.findById(id);
		Customer customer=null;
		if(result.isPresent()) {
			
			customer=result.get();
		}else {
			
			return ResponseEntity.notFound().build();
		}
		
		customer.setName(cusdetils.getName());
		customer.setLocation(cusdetils.getLocation());
		customer.setCusdate(cusdetils.getCusdate());
		
		Customer updateCustomer= customerService.save(customer);
		
		return ResponseEntity.ok().body(updateCustomer);
		
	}
		
	/**
	 * Method to delete customer 
	 * 
	 * 
	 * @return customer with given id
	 */	
		
	@DeleteMapping("/customers/{id}")
	public ResponseEntity<Customer> deleteCustomer(@PathVariable long id){
		logger.info("Inside the controller method deleteCustomer----> Customer_id :"
				+ id);
		
		Optional<Customer> result=customerService.findById(id);
		Customer customer=null;
		if(result.isPresent()) {
			
			customer=result.get();
		}else {
			
			return ResponseEntity.notFound().build();
		}
		
		customerService.delete(customer);
		
		return ResponseEntity.ok().build();
		
	}
	
	
}


