package com.sajan.order.service;

import com.sajan.order.util.dto.SetOrderDto;
import com.sajan.order.vo.Product;

public interface OrderProductService {

    Product save(SetOrderDto orderDto);

}
