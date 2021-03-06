package com.sajan.order.util.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserOrderDto {
    private Long orderId;
    private String status;
    private Long userId;
    private String email;
    private String firstName;
    private String lastName;
    private Long productId;
}
