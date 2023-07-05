package com.office.Customer.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Rating {

    private Long ratingId;
    private Long customerId;
    private int rating;
    private String feedback;
    private Long restId;
    private Restaurant restaurant;
}