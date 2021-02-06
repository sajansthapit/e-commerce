package com.sajan.order.util.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HeaderDto {
    private String message;
    private Boolean success;
}
