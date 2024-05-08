package com.example.restservice.service;

import com.example.restservice.model.ProductOrder;
import com.example.restservice.repository.ProductOrderRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductOrderService {

    private final ProductOrderRepository repository;

    @Autowired
    public ProductOrderService(ProductOrderRepository repository){
        this.repository = repository;
    }

    @Transactional
    public ProductOrder createProductOrder(ProductOrder order) {
        return repository.save(order);
    }
}
