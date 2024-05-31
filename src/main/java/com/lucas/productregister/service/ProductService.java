package com.lucas.productregister.service;

import com.lucas.productregister.DTO.ProductRequestDTO;
import com.lucas.productregister.DTO.ProductResponseDTO;
import com.lucas.productregister.domain.Product;
import com.lucas.productregister.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public ResponseEntity<List<ProductResponseDTO>> findAll() {
        List<Product> products = productRepository.findAll();
        return ResponseEntity.ok(products.stream().map(ProductResponseDTO::new).toList());
    }

    public ResponseEntity<String> save(ProductRequestDTO productData) {
        if (productRepository.existsByName(productData.name())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).
                    body("Product with name: "+productData.name()+" already exists.");
        }
        productRepository.save(new Product(productData));
        return ResponseEntity.status(HttpStatus.CREATED).body("Product saved.");
    }

}
