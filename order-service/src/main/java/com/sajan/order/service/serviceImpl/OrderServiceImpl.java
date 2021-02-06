package com.sajan.order.service.serviceImpl;

import com.sajan.order.domain.Orders;
import com.sajan.order.repository.OrderRepository;
import com.sajan.order.service.OrderProductService;
import com.sajan.order.service.OrderService;
import com.sajan.order.util.HeaderUtil;
import com.sajan.order.util.dto.HeaderDto;
import com.sajan.order.util.dto.SetOrderDto;
import com.sajan.order.util.dto.UserOrderDto;
import com.sajan.order.util.exception.NoSuchElementException;
import com.sajan.order.vo.Product;
import com.sajan.order.vo.Users;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final RestTemplate restTemplate;
    private final OrderProductService orderProductService;

    @Override
    public UserOrderDto save(SetOrderDto orderDto) {
        UserOrderDto userOrderDto = new UserOrderDto();
        String getUserUrl = "http://localhost:8003/users/get/" + orderDto.getUserId();
        ResponseEntity<Users> userResponse = restTemplate.getForEntity(getUserUrl, Users.class);
        HeaderDto userHeader = HeaderUtil.getHeaders(userResponse);
        if(!userHeader.getSuccess() || userResponse.getBody() == null){
            throw new NoSuchElementException(userHeader.getMessage());
        }
        Users users = userResponse.getBody();

        Orders orders = new Orders();
        orders.setStatus("ACTIVE");
        orders.setUserId(orderDto.getUserId());
        orderRepository.save(orders);

        Product product = orderProductService.save(orderDto);

        userOrderDto.setOrderId(orders.getId());
        userOrderDto.setStatus(orders.getStatus());
        userOrderDto.setUserId(users.getId());
        userOrderDto.setEmail(users.getEmail());
        userOrderDto.setFirstName(users.getFirstName());
        userOrderDto.setLastName(users.getLastName());
        userOrderDto.setProductId(product.getId());
        return userOrderDto;
    }
}
