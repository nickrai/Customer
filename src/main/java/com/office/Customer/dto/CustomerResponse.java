package com.office.Customer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerResponse {

    private Long customerId;
    private String customerName;
    private String email;
    private String about;
    private List<Rating> ratings;
}
