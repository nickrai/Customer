package com.office.Customer.Controller;

import com.office.Customer.Service.CustomerService;
import com.office.Customer.dto.CustomerResponse;
import com.office.Customer.entity.Customer;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
@AllArgsConstructor
public class CustomerController {
   @Autowired
    private CustomerService customerService;
    @PostMapping
    public Customer create(@RequestBody Customer customer)
    {
        return customerService.create(customer);
    }

  @GetMapping
  public List<Customer> getAll()
  {
      return customerService.getAll();

  }

    @GetMapping("/{customerId}")
    public CustomerResponse getByCustomerId(@PathVariable Long customerId) {
        return customerService.getByCustomerId(customerId);
    }
//    @GetMapping("/{customerId}")
//    public Customer getByCustomerId(@PathVariable("customerId") Long customerId) {
//        return customerService.getByCustomerId(customerId);
//    }
   // @GetMapping("/{customerId}")
    //public List<Ratings> getByCustomerId(@PathVariable("customerId") Long customerId) {
      //  return customerService.getRatingsByCustomerId(customerId);
    //}

}
