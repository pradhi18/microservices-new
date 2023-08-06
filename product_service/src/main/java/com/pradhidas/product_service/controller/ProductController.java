package com.pradhidas.product_service.controller;

import com.pradhidas.product_service.dto.ProductRequest;
import com.pradhidas.product_service.dto.ProductResponse;
import com.pradhidas.product_service.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductRequest productRequest) {
        productService.createProduct(productRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/increase-memory")
    public String increaseMemory() {
        allocateMemory();
        return "Memory increased";
    }

    private void allocateMemory() {
        List<byte[]> memoryIntensiveList = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            memoryIntensiveList.add(new byte[1024 * 1024]); // Allocate 1MB each time
        }
    }
}
