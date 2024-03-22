package com.ecommerce.ecommercebackend.repositories;

import com.ecommerce.ecommercebackend.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

// A repository permit to make the connection between the DB and services
public interface IProductRepository extends JpaRepository<Product, Integer> {
}
