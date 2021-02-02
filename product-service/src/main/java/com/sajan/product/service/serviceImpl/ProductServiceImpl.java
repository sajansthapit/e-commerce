package com.sajan.product.service.serviceImpl;

import com.sajan.product.domain.Category;
import com.sajan.product.domain.Product;
import com.sajan.product.repository.ProductRepository;
import com.sajan.product.service.CategoryService;
import com.sajan.product.service.ProductService;
import com.sajan.product.util.dto.ProductDto;
import com.sajan.product.util.exception.NoSuchElementException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryService categoryService;

    @Override
    public Product save(ProductDto productDto) {
        List<Category> categoryList = new ArrayList<>();
        for (Long categoryId : productDto.getCategories()) {
            categoryList.add(categoryService.findById(categoryId));
        }
        Product product = new Product();
        product.setCategories(categoryList);
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setDescription(productDto.getDescription());
        product.setStock(productDto.getStock());
        product.setStatus(productDto.getStatus());
        return productRepository.save(product);
    }

    @Override
    public Product findById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        return product.orElseThrow(() -> new NoSuchElementException("Product not found"));
    }
}
