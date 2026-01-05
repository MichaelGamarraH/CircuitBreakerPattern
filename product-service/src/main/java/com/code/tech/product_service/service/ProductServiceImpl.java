package com.code.tech.product_service.service;

import com.code.tech.product_service.entity.Product;
import com.code.tech.product_service.entity.dto.ProductDTO;
import com.code.tech.product_service.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;

    @Override
    public Product createProduct(ProductDTO productDTO) {
        return productRepository.save(Product.builder()
                .name(productDTO.name())
                .category(productDTO.category())
                .quantity(productDTO.quantity())
                .price(productDTO.price())
                .build());
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product with id " + id + " was not found"));
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
