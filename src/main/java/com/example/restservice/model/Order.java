package com.example.restservice.model;

import java.util.ArrayList;
import java.util.Date;

import org.hibernate.mapping.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import com.example.restservice.model.ProductOrder;




@Entity
@Table(name = "order")
public class Order {
 
    public enum OrderStatus {
        WYSTAWIONE, PRZYJETE, OPLACONE, ANULOWANE
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

    @Column(name ="date")
    @Temporal(TemporalType.DATE)
    private Date datePlaced;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDatePlaced() {
        return datePlaced;
    }

    public void setDatePlaced(Date datePlaced) {
        this.datePlaced = datePlaced;
    }
}