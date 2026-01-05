package com.code.tech.product_service.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "products")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String category;
    private int quantity;
    private float price;

    public Product(String name,String category,int quantity, float price){
        this.name = name;
        this.category = category;
        this.quantity = quantity;
        this.price = price;
    }

}
