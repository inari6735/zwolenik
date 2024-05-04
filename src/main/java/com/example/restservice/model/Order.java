package com.example.restservice.model;

import java.util.ArrayList;

import org.hibernate.mapping.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import com.example.restservice.model.ProductOrder;

@Entity
@Table(name = "orders")
public class Order {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name ="paid")
    private Boolean paid;  

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
    private List<ProductOrder> products = new ArrayList<>();

    public Double getTotalPrice() {
        return products.stream()
                       .mapToDouble(ProductOrder::getPrice)
                       .sum();
    }

  
}