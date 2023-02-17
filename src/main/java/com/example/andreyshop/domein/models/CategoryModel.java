package com.example.andreyshop.domein.models;

import com.example.andreyshop.domein.enums.CategoryName;
import lombok.*;

@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
@Builder
public class CategoryModel {
    private Long id;
    private CategoryName name;
    private String description;


}
