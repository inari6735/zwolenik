package com.example.restservice.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restservice.service.ProductService;
import com.example.restservice.model.Product;
import com.example.restservice.repository.ProductRepository;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // @GetMapping("/products/{id}")
    // public ResponseEntity<Product> getUsersById(@PathVariable(value = "id") Long userId) throws ResourceNotFoundException {
    //     Product product = productRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("Product not found on :: " + userId));
    //     return ResponseEntity.ok().body(product);
    // }

    // @PostMapping("/products")
    // public Product saveProduct(@Validated @RequestBody Product product) {
    //     return productRepository.save(product);
    // }


}