package com.example.restservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "product_order")
public class ProductOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name ="product_id")
    private Integer productId;
    
    @Column(name ="color_id")
    private Integer color;


    @Column(name = "specification", columnDefinition = "json")
    private String specification;
  
  
    // @Column(name ="product_id")
    // private double thickness;
     
    // @Column(name ="product_id")
    // private double price;

    // @Column(name ="product_id")
    // private double width;

    // @Column(name ="product_id")
    // private double height;

   
}