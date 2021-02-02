package com.sajan.product.controller;

import com.sajan.product.domain.Category;
import com.sajan.product.service.CategoryService;
import com.sajan.product.util.HeaderUtil;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@AllArgsConstructor
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping("/save")
    public ResponseEntity<Category> save(@RequestBody Category category) throws URISyntaxException {
        Category result = categoryService.save(category);
        return ResponseEntity.created(new URI("/category/" + result.getId()))
                .headers(HeaderUtil.createEntityCreationAlert("Category"))
                .body(result);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Category> find(@PathVariable Long id) {
        Category result = categoryService.findById(id);
        return ResponseEntity.ok().headers(HeaderUtil.getEntityAlert("Category"))
                .body(result);
    }
}
