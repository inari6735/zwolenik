package com.example.restservice.service;


import com.example.restservice.model.Order;
import com.example.restservice.model.ProductOrder;
import com.example.restservice.repository.OrderRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public Order createOrder(Order orderDTO) {
        Order order = new Order();
        order.setEmail(orderDTO.getEmail());
        order.setPaymentMethod(orderDTO.getPaymentMethod());

        List<ProductOrder> configurations = orderDTO.getConfigurations().stream()
                .map(cfg -> {
                    ProductOrder orderP = new ProductOrder();
                    orderP.setProductId(cfg.getProductId());
                    orderP.setSpecification(cfg.getSpecification());
                    orderP.setPrice(cfg.getPrice());
                    orderP.setAmount(cfg.getAmount());
                    orderP.setOrder(order);

                    return orderP;
                })
                .collect(Collectors.toList());

        order.setConfigurations(configurations);


        return orderRepository.save(order);
    }


}
