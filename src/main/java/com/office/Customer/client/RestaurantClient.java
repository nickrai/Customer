package com.office.Customer.client;

import com.office.Customer.dto.Restaurant;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="restaurant", url = "http://localhost:8112/")
public interface RestaurantClient {
    @GetMapping("/restaurants/{restId}")
    Restaurant getRestaurant(@PathVariable Long restId);
}
