package com.sajan.order.util.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserOrderDto {
    private Long orderId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String status;
    private Long userId;
    private String email;
    private String firstName;
    private String lastName;
}
