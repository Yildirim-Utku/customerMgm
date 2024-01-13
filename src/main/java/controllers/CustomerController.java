package controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import models.Customer;

import services.CustomerService;

@RestController
@RequestMapping("/app/customers")
public class CustomerController {
	@Autowired
	CustomerService customerService;

	@GetMapping
	public List<Customer> getCustomerList() {
		return customerService.getCustomerList();
	}

	@GetMapping("/{custId}")
	public Customer getOneCustomer(@PathVariable Long custId) {
		return customerService.getOneCustomer(custId);
	}

	@PostMapping
	public Customer addCustomer(@RequestBody Customer customer) {
		return customerService.addCustomer(customer);
	}

	@PutMapping("/{custId}")
	public Customer updateCustomer(@PathVariable Long custId, @RequestBody Customer updatedCustomer) {
		return customerService.updateCustomer(custId, updatedCustomer);
	}
	
	@DeleteMapping("/{custId}")
	public void deleteCustomer(@PathVariable Long custId) {
		customerService.deleteCustomer(custId);
	}
}
