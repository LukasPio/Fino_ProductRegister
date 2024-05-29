package com.lucas.productregister.controller;

import com.lucas.productregister.DTO.ProductResponseDTO;
import com.lucas.productregister.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping(path = "/hello")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("Hello World, all are working here.");
    }

    @GetMapping
    public ResponseEntity<List<ProductResponseDTO>> findAll() {
        return productService.findAll();
    }
}
