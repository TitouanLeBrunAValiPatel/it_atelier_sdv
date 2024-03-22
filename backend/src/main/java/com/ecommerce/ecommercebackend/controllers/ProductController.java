package com.ecommerce.ecommercebackend.controllers;

import com.ecommerce.ecommercebackend.dtos.ProductCreate;
import com.ecommerce.ecommercebackend.entities.Product;
import com.ecommerce.ecommercebackend.exceptions.CategoryException;
import com.ecommerce.ecommercebackend.exceptions.ProductException;
import com.ecommerce.ecommercebackend.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "products/", consumes = APPLICATION_JSON_VALUE)
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // ResponseEntity permit to personalize your httpResponse


    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping(path = "", consumes = {"*/*"})
    public List<Product> getProducts(){
        return this.productService.getProducts();
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping(path = "/{id}", consumes = {"*/*"})
    public ResponseEntity<Product> getProduct(@PathVariable(name = "id") int productId) throws ProductException {
        return ResponseEntity.ok(this.productService.getProduct(productId));
    }


    @PostMapping("/new")
    public ResponseEntity<Product> createProduct(@RequestBody @Valid ProductCreate product) throws CategoryException, ProductException {
        return new ResponseEntity<>(this.productService.createProduct(product), HttpStatus.CREATED);
    }
}
