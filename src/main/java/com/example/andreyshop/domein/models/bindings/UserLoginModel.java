package com.example.andreyshop.domein.models.bindings;

import com.example.andreyshop.validation.validateUser.ValidateLoginForm;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
@ValidateLoginForm
public class UserLoginModel {
    private String username;
    private String password;
}
