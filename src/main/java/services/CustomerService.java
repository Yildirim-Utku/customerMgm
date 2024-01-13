package services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import models.Customer;
import repositories.CustomerRepository;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepository customerRepository;

	public Customer getOneCustomer(Long custId) {
		return customerRepository.findById(custId).orElse(null);
	}

	public Customer addCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	public void deleteCustomer(Long custId) {
		customerRepository.deleteById(custId);
	}

	public Customer updateCustomer(Long custId, Customer updateCustomer) {
		Optional<Customer> customer = customerRepository.findById(custId);
		if (customer.isPresent()) {
			Customer foundCustomer = customer.get();
			foundCustomer.setAd(updateCustomer.getAd());
			foundCustomer.setSoyad(updateCustomer.getSoyad());
			foundCustomer.setFiles(updateCustomer.getFiles());
			customerRepository.save(foundCustomer);
			return foundCustomer;
		} else {
			return null;
		}

	}

	public List<Customer> getCustomerList() {
		return customerRepository.findAll();
	}
}
