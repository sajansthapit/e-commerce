package com.sajan.product.service;

import com.sajan.product.domain.Category;

public interface CategoryService {
    Category save(Category category);

    Category findById(Long id);
}
