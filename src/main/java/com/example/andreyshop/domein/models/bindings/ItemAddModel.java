package com.example.andreyshop.domein.models.bindings;

import com.example.andreyshop.domein.entities.Category;
import com.example.andreyshop.domein.enums.CategoryName;
import com.example.andreyshop.domein.enums.Gender;
import com.example.andreyshop.validation.validateItem.ValidateItem;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class ItemAddModel {
    @Size(min = 2)
    @NotBlank
    @ValidateItem
    private String name;

    @NotNull
    @Positive
    private BigDecimal price;

    @Size(min = 3)
    @NotBlank
    private String description;

    @NotNull
    private Gender gender;

    @NotNull
    private CategoryName category;
}
