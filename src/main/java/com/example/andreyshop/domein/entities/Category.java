package com.example.andreyshop.domein.entities;

import com.example.andreyshop.domein.enums.CategoryName;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table
public class Category extends BaseEntity{

    @Column
    @Enumerated(EnumType.STRING)
    private CategoryName name;

    @Column(columnDefinition = "TEXT")
    private String description;
}
