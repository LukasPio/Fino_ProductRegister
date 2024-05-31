package com.lucas.productregister.service;

import com.lucas.productregister.DTO.ProductRequestDTO;
import com.lucas.productregister.DTO.ProductResponseDTO;
import com.lucas.productregister.domain.Product;
import com.lucas.productregister.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

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
                    body("Product with name: "+productData.name()+" already exists");
        }
        productRepository.save(new Product(productData));
        return ResponseEntity.status(HttpStatus.CREATED).body("Product saved");
    }

    public ResponseEntity<String> update(ProductRequestDTO productData, String oldName) {
        Optional<Product> optionalProduct = productRepository.findByName(oldName);
        if (optionalProduct.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product with name: "+oldName+" does not exist");
        Product product = optionalProduct.get();
        product.setName(productData.name());
        product.setDescription(productData.description());
        product.setPrice(productData.price());
        product.setQuantity(productData.quantity());
        product.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        productRepository.save(product);
        return ResponseEntity.status(HttpStatus.OK).body("Product was updated successfully");
    }

    @Transactional
    public ResponseEntity<String> delete(String productName) {
        Optional<Product> product = productRepository.findByName(productName);
        if (product.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product with name: "+productName+" does not exist");
        productRepository.delete(product.get());
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Product was deleted successfully");
    }
}
