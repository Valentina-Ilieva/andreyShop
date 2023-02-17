package com.example.andreyshop.domein.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@NoArgsConstructor
@Setter
@Getter
public class UserModel {
    private Long id;
    private String username;
    private String password;
    private String email;
    private BigDecimal budget;

}
