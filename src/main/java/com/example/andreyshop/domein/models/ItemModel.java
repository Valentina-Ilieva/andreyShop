package com.example.andreyshop.domein.models;

import com.example.andreyshop.domein.entities.Category;
import com.example.andreyshop.domein.enums.CategoryName;
import com.example.andreyshop.domein.enums.Gender;
import lombok.*;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class ItemModel {
    private String name;
    private BigDecimal price;
    private String description;
    private Gender gender;
    private CategoryModel category;
}
