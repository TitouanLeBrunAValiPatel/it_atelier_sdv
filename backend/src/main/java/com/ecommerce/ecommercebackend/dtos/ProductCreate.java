package com.ecommerce.ecommercebackend.dtos;

import com.ecommerce.ecommercebackend.entities.Category;
import com.ecommerce.ecommercebackend.services.CategoryService;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NotFound;

import java.util.Optional;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductCreate {

    @Positive(message = "The product must be in a category")
    private int idCategory;

    @NotNull(message = "The product must be have a name !")
    private String name;


    private String description;

    @PositiveOrZero(message = "The product can't less than 0 !")
    @Builder.Default
    private int stock = 0;

    @Min(value = 0, message = "The product must have a positive price !")
    @Builder.Default
    private int price = 0;

}
