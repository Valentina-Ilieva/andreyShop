package com.example.andreyshop.validation.validateUser;

import com.example.andreyshop.domein.models.UserModel;
import com.example.andreyshop.domein.models.bindings.UserLoginModel;
import com.example.andreyshop.services.UserService;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class UserLoginValidator implements ConstraintValidator<ValidateLoginForm, UserLoginModel> {

    private final UserService userService;

    @Autowired
    public UserLoginValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void initialize(ValidateLoginForm constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(UserLoginModel userLoginModel, ConstraintValidatorContext context) {
        UserModel user = this.userService.findByUsername(userLoginModel.getUsername());
        return user.getId() != null
                && user.getPassword()
                .equals(userLoginModel.getPassword());
    }
}
