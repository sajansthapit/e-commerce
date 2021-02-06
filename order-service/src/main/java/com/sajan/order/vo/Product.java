package com.sajan.order.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private long id;
    private String name;
    private String description;
    private Double price;
    private Long stock;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String status;
}
