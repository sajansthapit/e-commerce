package com.sajan.order.service;

import com.sajan.order.util.dto.SetOrderDto;
import com.sajan.order.util.dto.UserOrderDto;

public interface OrderService {

    UserOrderDto save(SetOrderDto orderDto);


}
