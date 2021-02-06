package com.sajan.order.util.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SetOrderDto {
    private Long productId;
    private Long userId;
    private Integer quantity;
}
