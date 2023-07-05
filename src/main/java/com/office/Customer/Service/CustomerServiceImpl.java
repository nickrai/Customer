package com.office.Customer.Service;

import com.office.Customer.Repository.CustomerRepository;
import com.office.Customer.client.RatingsClient;
import com.office.Customer.dto.CustomerResponse;
import com.office.Customer.dto.Rating;
import com.office.Customer.entity.Customer;
import com.office.Customer.client.RestaurantClient;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;


    @Autowired
    private RestaurantClient restaurantClient;

    @Autowired
    private RatingsClient ratingsClient;
    @Override
    public Customer create(Customer customer) {
        return customerRepository.save(customer);
    }
//
//    @Override
//    public Customer getByCustomerId(Long customerId) {
//        return customerRepository.findByCustomerId(customerId);
//    }


    @Override
    public CustomerResponse getByCustomerId(Long customerId)
    {
//        Customer customer=customerRepository.findByCustomerId(customerId);
//
//       Ratings[] ratingsOfCustomers=restTemplate.getForObject("http://localhost:8113/ratings/customers/" + customer.getCustomerId(),Ratings[].class);
//
//        List<Ratings> ratings = Arrays.stream(ratingsOfCustomers).toList();
//
//        List<Ratings> ratingsList= ratings.stream().map(rating -> {
//                //api call to restaurant to get hotel
//               ResponseEntity<Restaurant> forObject = restTemplate.getForEntity("http://localhost:8112/restaurants/"+rating.getRestId(), Restaurant.class);
//               Restaurant restaurant = forObject.getBody();
//
//
//               //set the hotel to rating
//               rating.setRestaurant(restaurant);
//                //return the rating
//                return rating;
//
//            }).collect(Collectors.toList());
//        customer.setRatings(ratingsList);
//        return customer;

        CustomerResponse customerResponse = new CustomerResponse();

        Customer existingCustomerDetails = customerRepository.findByCustomerId(customerId);
        customerResponse.setCustomerId(customerId);
        customerResponse.setCustomerName(existingCustomerDetails.getName());
        customerResponse.setEmail(existingCustomerDetails.getEmail());
        customerResponse.setAbout(existingCustomerDetails.getAbout());

        List<Rating> ratingsByCustomerId = ratingsClient.getRatingsByCustomerId(customerId);
        customerResponse.setRatings(ratingsByCustomerId);

        return customerResponse;

    }

   @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }
//
//    @Override
//    public List<Ratings> getRatingsByCustomerId(Long customerId) {
//
//       List<Ratings> listOfRatings = ratingsClient.getRatingsByCustomerId(customerId);
//        ArrayList<Ratings> lists = new ArrayList<Ratings>();
//        listOfRatings.stream().map(ratings -> {
//            lists.
//            return ratings;
//        }).collect(Collectors.toList());
//        return listOfRatings;
    }





