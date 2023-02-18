package ru.geekbrains.carts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.geekbrains.carts.repository.CustomerRepository;
import ru.geekbrains.carts.entities.Customer;
import ru.geekbrains.carts.entities.Order;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CustomerService{
    @Autowired
    CustomerRepository customerRepository;

    public Customer getCustomerByEmail(String email){
        return customerRepository.findByEmail(email);
    }

    public Customer createCustomer(Customer customer){
        return customerRepository.save(customer);
    }

    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

    public Customer getCustomerById(Integer id){
        return customerRepository.findOne(id);
    }

    public List<Order> getCustomerOrders(String email){
        return customerRepository.getCustomerOrders(email);
    }
}
