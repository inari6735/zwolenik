package com.example.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.Entity.Product;
import com.example.Repository.ProductRepository;

@Controller
@RequestMapping(path="/product")
public class MainController {
  @Autowired
  private ProductRepository productRepository;

  @GetMapping(path="/all")
  public @ResponseBody Iterable<Product> getAllProducts() {
    return productRepository.findAll();
  }
}
