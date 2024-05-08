package com.example.restservice.model;

import java.util.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


import jakarta.persistence.*;


@Entity
@Table(name = "orders")
public class Order {
 
    public enum OrderStatus {
        NIE_OPLACONE,WYSTAWIONE, PRZYJETE, OPLACONE, ANULOWANE
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name ="price")
    private Double price;

    @Enumerated(EnumType.STRING)
    @Column(name ="status")
    private OrderStatus status;

    @Column(name ="address", columnDefinition = "json")
    private String address;

    @Column(name ="email")
    private String email;

    @Column(name = "payment_method")
    private String paymentMethod;

    @Column(name ="date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datePlaced;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<ProductOrder> configurations;

    @PrePersist
    protected void onCreate() {
        datePlaced = new Date();
    }

    public List<ProductOrder> getConfigurations() {
        return configurations;
    }

    public void setConfigurations(List<ProductOrder> configurations) {
        this.configurations = configurations;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Map<String, Object> getAddress() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(address, Map.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error parsing JSON", e);
        }
    }

    public void setAddress(Map<String, Object> addressMap) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            this.address = objectMapper.writeValueAsString(addressMap);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error writing JSON", e);
        }
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Date getDatePlaced() {
        return datePlaced;
    }

    public void setDatePlaced(Date datePlaced) {
        this.datePlaced = datePlaced;
    }



    private String convertAddressToJSON(String name, String surname, String address, String city, String postcode, String deliveryOption) {
        Map<String, String> addressDetails = new HashMap<>();
        addressDetails.put("name", name);
        addressDetails.put("surname", surname);
        addressDetails.put("address", address);
        addressDetails.put("city", city);
        addressDetails.put("postcode", postcode);
        addressDetails.put("deliveryOption", deliveryOption);
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(addressDetails);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error creating address JSON", e);
        }
    }
}