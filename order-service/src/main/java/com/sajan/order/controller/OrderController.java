package com.sajan.order.controller;

import com.sajan.order.domain.Orders;
import com.sajan.order.service.OrderService;
import com.sajan.order.util.HeaderUtil;
import com.sajan.order.util.dto.SetOrderDto;
import com.sajan.order.util.dto.UserOrderDto;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;


@RestController
@RequestMapping("/order")
@AllArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/save")
    public ResponseEntity<UserOrderDto> save(@RequestBody SetOrderDto orderDto) throws URISyntaxException {
        UserOrderDto result = orderService.save(orderDto);
        return ResponseEntity.created(new URI("/order/" + result.getOrderId())).
                headers(HeaderUtil.createEntityCreationAlert("order"))
                .body(result);
    }
}
