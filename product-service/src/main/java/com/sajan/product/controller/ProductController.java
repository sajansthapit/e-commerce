package com.sajan.product.controller;

import com.sajan.product.domain.Product;
import com.sajan.product.service.ProductService;
import com.sajan.product.util.HeaderUtil;
import com.sajan.product.util.dto.ProductDto;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@AllArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @PostMapping("/save")
    public ResponseEntity<Product> save(@RequestBody ProductDto productDto) throws URISyntaxException {
        Product result = productService.save(productDto);
        return ResponseEntity.created(new URI("/product/" + result.getId()))
                .headers(HeaderUtil.createEntityCreationAlert("Product"))
                .body(result);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Product> find(@PathVariable Long id){
        Product result = productService.findById(id);
        return ResponseEntity.ok().headers(HeaderUtil.getEntityAlert("Product"))
                .body(result);
    }
}
