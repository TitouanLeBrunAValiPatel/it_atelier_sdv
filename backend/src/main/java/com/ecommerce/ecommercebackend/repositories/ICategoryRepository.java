package com.ecommerce.ecommercebackend.repositories;

import com.ecommerce.ecommercebackend.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category, Integer> {
}
