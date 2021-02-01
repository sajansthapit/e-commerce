package com.sajan.product.controller;

import com.sajan.product.domain.Category;
import com.sajan.product.service.CategoryService;
import com.sajan.product.util.HeaderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/save")
    public ResponseEntity<Category> save(@RequestBody Category category) throws URISyntaxException {
        Category result = categoryService.save(category);
        return ResponseEntity.created(new URI("/category/" + result.getId()))
                .headers(HeaderUtil.createEntityCreationAlert("Category", true))
                .body(result);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Category> find(@PathVariable Long id) {
        Category result = categoryService.findById(id);
        return ResponseEntity.ok().headers(HeaderUtil.getEntityAlert("Category", true))
                .body(result);
    }
}
