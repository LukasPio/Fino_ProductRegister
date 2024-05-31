package com.lucas.productregister.controller;

import com.lucas.productregister.DTO.ProductRequestDTO;
import com.lucas.productregister.DTO.ProductResponseDTO;
import com.lucas.productregister.service.ProductService;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping(path = "/hello")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("Hello visitant, look that all are working here.");
    }

    @GetMapping
    public ResponseEntity<List<ProductResponseDTO>> findAll() {
        return productService.findAll();
    }

    @PostMapping
    public ResponseEntity<String> save(@RequestBody ProductRequestDTO productData) {
        return productService.save(productData);
    }

    @PutMapping(path = "/{oldName}")
    public ResponseEntity<String> update(@RequestBody ProductRequestDTO productData, @NotNull @PathVariable String oldName) {
        return productService.update(productData, oldName);
    }
}
