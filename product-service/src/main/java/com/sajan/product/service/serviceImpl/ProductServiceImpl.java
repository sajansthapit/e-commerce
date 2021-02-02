package com.sajan.product.service.serviceImpl;

import com.sajan.product.domain.Category;
import com.sajan.product.domain.Product;
import com.sajan.product.repository.ProductRepository;
import com.sajan.product.service.CategoryService;
import com.sajan.product.service.ProductService;
import com.sajan.product.util.dto.ProductDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryService categoryService;

    @Override
    public Product save(ProductDto productDto) {
        List<Category> categoryList = new ArrayList<>();
        productDto.getCategories().forEach(categoryId -> {
            categoryList.add(categoryService.findById(categoryId));
        });
        Product product = new Product();
        product.setCategories(categoryList);
        product.setName(productDto.getName());

        return null;
    }
}
