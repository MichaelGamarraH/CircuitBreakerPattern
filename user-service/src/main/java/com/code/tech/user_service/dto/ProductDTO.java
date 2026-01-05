package com.code.tech.user_service.dto;

public record ProductDTO(
        Long id,
        String name,
        String category,
        int quantity,
        float price) {
}
