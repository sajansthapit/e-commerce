package com.sajan.order;

import com.sajan.order.domain.Orders;
import com.sajan.order.service.OrderService;
import com.sajan.order.util.dto.UserOrderDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/order")
@RestController
@AllArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/save")
    public UserOrderDto save(@RequestBody Orders orders){
        return orderService.save(orders);
    }
}
