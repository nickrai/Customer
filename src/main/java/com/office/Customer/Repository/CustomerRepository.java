package com.office.Customer.Repository;

import com.office.Customer.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
    Customer findByCustomerId(Long customerId);
}
