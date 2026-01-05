package com.code.tech.user_service.controller;

import com.code.tech.user_service.dto.ProductDTO;
import com.code.tech.user_service.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user-service")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/products")
    public ResponseEntity<List<ProductDTO>> displayProducts() {
        List<ProductDTO> products = userService.displayProducts();
        return ResponseEntity.status(HttpStatus.OK).body(products);
    }
}
