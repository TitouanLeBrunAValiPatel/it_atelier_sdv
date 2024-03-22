package com.ecommerce.ecommercebackend.services;

import com.ecommerce.ecommercebackend.entities.Category;
import com.ecommerce.ecommercebackend.exceptions.CategoryException;
import com.ecommerce.ecommercebackend.repositories.ICategoryRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService {
    private final ICategoryRepository iCategoryRepository;

    public CategoryService(ICategoryRepository iCategoryRepository){
        this.iCategoryRepository = iCategoryRepository;

    }

    public Category getCategory(int idCategory) throws CategoryException {
        Optional<Category> optionalCategory = this.iCategoryRepository.findById(idCategory);
        if (optionalCategory.isPresent()) {
            return optionalCategory.get();
        } else {
            throw new CategoryException("Category with ID " + idCategory + " not found");
        }
    }
}
