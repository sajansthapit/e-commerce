package com.sajan.product.service.serviceImpl;

import com.sajan.product.domain.Category;
import com.sajan.product.repository.CategoryRepository;
import com.sajan.product.service.CategoryService;
import com.sajan.product.util.exception.NoSuchElementException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category findById(Long id) {
        Optional<Category> category = categoryRepository.findById(id);
        return category.orElseThrow(() -> new NoSuchElementException("Category Not found"));
    }
}
