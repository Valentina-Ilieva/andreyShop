package com.example.andreyshop.domein.models.bindings;

import com.example.andreyshop.domein.entities.Category;
import com.example.andreyshop.domein.enums.Gender;
import lombok.*;

import java.math.BigDecimal;

@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
@Builder
public class ItemViewModel {
    private Long id;
    private String name;
    private BigDecimal price;
    private Category category;
    private Gender gender;
    private String imageUrl;
//
//    public ItemViewModel setImageUrl(String imageUrl) {
//
//        String.format("/img/%s-%s.jpg", )
//        return this;
//    }
}
