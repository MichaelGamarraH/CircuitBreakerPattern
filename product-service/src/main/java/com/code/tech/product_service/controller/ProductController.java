package com.code.tech.product_service.controller;

import com.code.tech.product_service.entity.Product;
import com.code.tech.product_service.entity.dto.ProductDTO;
import com.code.tech.product_service.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<Product> createProduct(ProductDTO productDTO){
        Product product = productService.createProduct(productDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id){
        Product product = productService.getProductById(id);
        return ResponseEntity.status(HttpStatus.OK).body(product);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> products = productService.getAllProducts();
        return ResponseEntity.status(HttpStatus.OK).body(products);
    }
}
