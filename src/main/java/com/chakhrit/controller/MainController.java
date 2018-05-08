package com.chakhrit.controller;

import com.chakhrit.Custom.ResourceNotFoundException;
import com.chakhrit.model.Customer;
import com.chakhrit.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;



@RestController

@RequestMapping(path = "/api")
public class MainController {
    @Autowired
    private CustomerRepository customerRepository;




    //get all customers
    @GetMapping("/customers")
    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    //post customer
    @PostMapping("/customers")
    public Customer createCustomer(@Valid @RequestBody Customer customer) {
        return customerRepository.save(customer);
    }

    //get single customer
    @GetMapping("/customers/{id}")
    public Customer getCustomerById(@PathVariable(value = "id") Long id) {
        return customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer", "id", id));
    }

    //update customer
    @PutMapping("/customers/{id}")
    public Customer updateCustomer(@PathVariable(value = "id") Long id, @Valid @RequestBody Customer customerDetail) {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer", "id", id));
        customer.setEmail(customerDetail.getEmail());
        customer.setPassword(customerDetail.getPassword());
        customer.setName(customerDetail.getName());
        customer.setLastname(customerDetail.getLastname());
        customer.setAddress(customerDetail.getAddress());
        customer.setTelno(customerDetail.getTelno());

        Customer updateCustomer = customerRepository.save(customer);
        return updateCustomer;
    }

    //delete xustomer
    @DeleteMapping("/customers/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable(value = "id") Long id) {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer", "id", id));

        customerRepository.delete(customer);

        return ResponseEntity.ok().build();
    }
  
}
