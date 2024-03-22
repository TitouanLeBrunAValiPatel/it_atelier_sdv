package com.ecommerce.ecommercebackend.services;

import com.ecommerce.ecommercebackend.dtos.ProductCreate;
import com.ecommerce.ecommercebackend.entities.Category;
import com.ecommerce.ecommercebackend.entities.Product;
import com.ecommerce.ecommercebackend.exceptions.CategoryException;
import com.ecommerce.ecommercebackend.exceptions.ProductException;
import com.ecommerce.ecommercebackend.repositories.IProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final IProductRepository iProductRepository;
    private final CategoryService categoryService;

    public ProductService(IProductRepository iProductRepository,CategoryService categoryService ){
        this.iProductRepository = iProductRepository;
        this.categoryService = categoryService;

    }

    public List<Product> getProducts(){

        return this.iProductRepository.findAll();
    }

    public Product getProduct(int productId) throws ProductException {
        Optional<Product> optionalProduct = this.iProductRepository.findById(productId);
        if (optionalProduct.isPresent()) {
            return optionalProduct.get();
        } else {
            throw new ProductException("Product Not found");
        }

    }

    public Product createProduct(ProductCreate productCreate) throws CategoryException, ProductException {
        Product newProduct = convertToProduct(productCreate);
        newProduct = this.iProductRepository.save(newProduct);
        return newProduct;

    }

    private Product convertToProduct(ProductCreate productCreate) throws CategoryException {
        Product newProduct = new Product();

        int idCategory = productCreate.getIdCategory();
        Category category = categoryService.getCategory(idCategory);
        newProduct.setCategory(category);

        newProduct.setName(productCreate.getName());
        newProduct.setDescription(productCreate.getDescription());
        newProduct.setStock(productCreate.getStock());
        newProduct.setPrice(productCreate.getPrice());

        return newProduct;
    }
}
