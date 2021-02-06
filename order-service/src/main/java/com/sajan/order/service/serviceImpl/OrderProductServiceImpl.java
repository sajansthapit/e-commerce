package com.sajan.order.service.serviceImpl;

import com.sajan.order.domain.OrderProduct;
import com.sajan.order.repository.OrderProductRepository;
import com.sajan.order.service.OrderProductService;
import com.sajan.order.util.HeaderUtil;
import com.sajan.order.util.dto.HeaderDto;
import com.sajan.order.util.dto.SetOrderDto;
import com.sajan.order.util.exception.NoSuchElementException;
import com.sajan.order.vo.Product;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class OrderProductServiceImpl implements OrderProductService {

    private final RestTemplate restTemplate;
    private final OrderProductRepository orderProductRepository;

    @Override
    public Product save(SetOrderDto orderDto) {
        String getProductUrl = "http://localhost:8001/product/get/" + orderDto.getProductId();
        ResponseEntity<Product> productResponse = restTemplate.getForEntity(getProductUrl, Product.class);
        HeaderDto productHeader = HeaderUtil.getHeaders(productResponse);
        if (!productHeader.getSuccess() || productResponse.getBody() == null) {
            throw new NoSuchElementException(productHeader.getMessage());
        }
        Product product = productResponse.getBody();
        OrderProduct orderProduct = new OrderProduct();
        orderProduct.setOrderId(orderDto.getProductId());
        orderProduct.setProductId(product.getId());
        orderProduct.setQuantity(orderProduct.getQuantity());
        orderProduct.setStatus("ACTIVE");
        orderProductRepository.save(orderProduct);
        return product;
    }
}
