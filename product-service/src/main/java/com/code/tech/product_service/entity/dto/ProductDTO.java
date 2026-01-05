package com.code.tech.product_service.entity.dto;

public record ProductDTO(
        String name,
        String category,
        int quantity,
        float price) {
}
