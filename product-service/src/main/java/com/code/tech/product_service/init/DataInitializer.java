package com.code.tech.product_service.init;

import com.code.tech.product_service.entity.Product;
import com.code.tech.product_service.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {

        List<Product> products = List.of(
            Product.builder()
                    .name("Laptop")
                    .category("Electronics")
                    .quantity(10)
                    .price(1200.00f)
                    .build(),

            Product.builder()
                    .name("Phone")
                    .category("Electronics")
                    .quantity(25)
                    .price(800.00f)
                    .build(),

            Product.builder()
                    .name("Shoes")
                    .category("Fashion")
                    .quantity(50)
                    .price(100.00f)
                    .build(),

            Product.builder()
                    .name("T-Shirt")
                    .category("Fashion")
                    .quantity(100)
                    .price(20.00f)
                    .build(),

            Product.builder()
                    .name("Chocolate")
                    .category("Food")
                    .quantity(200)
                    .price(5.50f)
                    .build(),

            Product.builder()
                    .name("Coffee")
                    .category("Food")
                    .quantity(80)
                    .price(12.00f)
                    .build());

        productRepository.saveAll(products);
    }
}
