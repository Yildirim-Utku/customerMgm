package repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import models.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
