package ru.geekbrains.carts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.geekbrains.carts.repository.OrderRepository;
import ru.geekbrains.carts.entities.Order;

@Service
@Transactional
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    public Order createOrder(Order order){
        order.setOrderNumber(String.valueOf(System.currentTimeMillis()));
        return orderRepository.save(order);
    }

    public Order getOrder(String orderNumber){
        return orderRepository.findByOrderNumber(orderNumber);
    }
}
