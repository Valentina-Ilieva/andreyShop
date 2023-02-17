package com.example.andreyshop.domein.entities;

import com.example.andreyshop.domein.enums.Gender;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table
public class Item extends BaseEntity{
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private String description;

    @Column
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @ManyToOne
    private Category category;

}
