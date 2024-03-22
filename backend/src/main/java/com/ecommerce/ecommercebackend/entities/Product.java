package com.ecommerce.ecommercebackend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // avoid to add getter and setter
@Entity
@Table(name = "products")
@AllArgsConstructor // avoid to implement the constructor and tell us that all variable are in the constructor
@NoArgsConstructor // Authorize a constructor without arguments
public class Product {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_category")
    private Category category;

    private String name;

    private String description;

    private int stock;

    private int price;
}
