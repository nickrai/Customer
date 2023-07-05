package com.office.Customer.Service;

import com.office.Customer.dto.CustomerResponse;
import com.office.Customer.entity.Customer;

import java.util.List;

public interface CustomerService {
    Customer create(Customer customer);

   // Response getByCustomerId(Long customerId);

    CustomerResponse getByCustomerId(Long customerId);

    List<Customer> getAll();
  //  List<Ratings> getRatingsByCustomerId(Long customerId);


}
