package com.example.andreyshop.domein.models.bindings;

import com.example.andreyshop.validation.passwordMatcher.PasswordMatch;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@NoArgsConstructor
@Setter
@Getter
@PasswordMatch
public class UserRegisterModel {
    @Size(min = 2)
    @NotBlank
    private String username;


    @Size(min = 2)
    @NotBlank
    private String password;

    @NotNull
    private String confirmPassword;

    @Email
    @NotBlank
    private String email;

    @NotNull
    @Positive
    private BigDecimal budget;
}
