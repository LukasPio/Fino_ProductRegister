package com.lucas.productregister.DTO;

import com.lucas.productregister.domain.Product;

public record ProductResponseDTO(String name, String description, Float price, Integer quantity) {
    public ProductResponseDTO(Product product) {
        this(product.getName(), product.getDescription(), product.getPrice(), product.getQuantity());
    }
}
