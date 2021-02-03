package com.sajan.order.service.serviceImpl;

import com.sajan.order.domain.Orders;
import com.sajan.order.repository.OrderRepository;
import com.sajan.order.service.OrderService;
import com.sajan.order.util.dto.UserOrderDto;
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

    @Override
    public UserOrderDto save(Orders order) {
        UserOrderDto userOrderDto = new UserOrderDto();
        ResponseEntity<Users> response = restTemplate.getForEntity("http://localhost:8003/users/get/" + order.getUserId(), Users.class);
        Users users = response.getBody();
        log.info(users != null ? users.toString() : null);
        log.info(response.getStatusCode().toString());
        return null;
    }
}
