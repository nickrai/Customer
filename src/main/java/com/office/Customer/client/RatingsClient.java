package com.office.Customer.client;

import com.office.Customer.dto.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="ratings", url = "http://localhost:8113/")
public interface RatingsClient {
  @GetMapping("/ratings/customers/{customerId}")
  List<Rating> getRatingsByCustomerId(@PathVariable("customerId") Long customerId);

}
