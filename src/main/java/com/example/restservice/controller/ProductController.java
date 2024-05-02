package com.example.restservice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;
import com.example.restservice.model.Product;
import com.example.restservice.repository.ProductRepository;

@Controller
@RequestMapping(path="/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping(path="/all")
    public  @ResponseBody Iterable<Product> getAllProducts() {
        return productRepository.findAll();
    }
}