package com.sajan.order.service;

import com.sajan.order.domain.Orders;
import com.sajan.order.util.dto.UserOrderDto;

public interface OrderService {

    UserOrderDto save(Orders order);
}
