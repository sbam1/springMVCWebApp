package com.suseel.webStore.domain.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.suseel.webStore.domain.Customer;
import com.suseel.webStore.domain.repository.CustomerRepository;

@Repository
public class InMemoryCustomerRepository implements CustomerRepository {
	
	private List<Customer> customers = new ArrayList<Customer>();
	
	public InMemoryCustomerRepository() {
		Customer customer1 = new Customer(1, "suseel bam", "4120 Appian Way Ct.");
		customer1.setNoOfOrdersMade(100);
		Customer customer2 = new Customer(1, "susma pun", "4120 Appian Way Ct.");
		customer2.setNoOfOrdersMade(100);
		Customer customer3 = new Customer(1, "krishna bhatrai", "4120 Appian Way Ct.");
		customer3.setNoOfOrdersMade(100);
		Customer customer4 = new Customer(1, "Rejesh yadav", "4120 Appian Way Ct.");
		customer4.setNoOfOrdersMade(100);
		customers.add(customer1);
		customers.add(customer2);
		customers.add(customer3);
		customers.add(customer4);
	}

	@Override
	public List<Customer> getAllCustomers() {
		return customers;
	}

}
