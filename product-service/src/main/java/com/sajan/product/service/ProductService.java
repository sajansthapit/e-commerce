package com.sajan.product.service;

import com.sajan.product.domain.Product;
import com.sajan.product.util.dto.ProductDto;

public interface ProductService {

    Product save(ProductDto productDto);

}
