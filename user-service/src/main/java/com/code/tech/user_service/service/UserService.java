package com.code.tech.user_service.service;
import com.code.tech.user_service.dto.ProductDTO;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class UserService {

    private final RestTemplate restTemplate;
    private static final String BASEURL = "http://localhost:8082/v1/api/product";

    public UserService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @CircuitBreaker(name = "userService", fallbackMethod = "getAllAvailableProducts")
    public List<ProductDTO> displayProducts() {
        String url = BASEURL + "/getAll";
        ProductDTO[] products = restTemplate.getForObject(url, ProductDTO[].class);
        return Arrays.asList(products);
    }


    public List<ProductDTO> getAllAvailableProducts(Throwable t) {
        return Stream.of(
                new ProductDTO(105L, "Gaming Laptop", "electronics", 50, 1500.00f),
                new ProductDTO(106L, "Smartphone", "electronics", 15, 950.00f),
                new ProductDTO(107L, "Wireless Earbuds", "electronics", 52, 120.00f),
                new ProductDTO(108L, "Running Shoes", "fashion", 10, 85.00f),
                new ProductDTO(109L, "Jeans", "fashion", 80, 45.00f),
                new ProductDTO(110L, "Energy Drink Pack", "food", 15, 18.50f),
                new ProductDTO(111L, "Organic Honey", "food", 26, 12.75f),
                new ProductDTO(112L, "Green Tea", "food", 24, 9.99f)
        ).collect(Collectors.toList());
    }
}


