package org.ayrotek.controller;


import lombok.AllArgsConstructor;
import org.ayrotek.model.IdRequest;
import org.ayrotek.model.Product;
import org.ayrotek.model.ProductRequest;
import org.ayrotek.service.UserProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/tax")
public class UserProductContoller {

    private final UserProductService userProductService;

    @GetMapping
    public void createProduct(@RequestBody Product product){
        userProductService.createProduct(product);
    }

    @PostMapping
    public void updateProduct(@RequestBody ProductRequest productRequest) {
        userProductService.updateProduct(productRequest.getId().getId(), productRequest.getProduct());
    }

    @DeleteMapping
    public void deleteProduct(@RequestBody IdRequest id) {
        userProductService.deleteProduct(id.getId());
    }

    @GetMapping(value = "/products")
    public List<Product> getProducts() {
        return userProductService.getAllProducts();
    }
}

