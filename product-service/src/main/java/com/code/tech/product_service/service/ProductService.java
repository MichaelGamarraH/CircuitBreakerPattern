package com.code.tech.product_service.service;

import com.code.tech.product_service.entity.Product;
import com.code.tech.product_service.entity.dto.ProductDTO;

import java.util.List;

public interface ProductService{
    Product createProduct(ProductDTO productDTO);
    Product getProductById(Long id);
    List<Product> getAllProducts();
}
