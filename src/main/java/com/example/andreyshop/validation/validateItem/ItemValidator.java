package com.example.andreyshop.validation.validateItem;

import com.example.andreyshop.repositories.ItemRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ItemValidator implements ConstraintValidator<ValidateItem, String> {
    private final ItemRepository itemRepository;

    public ItemValidator(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public void initialize(ValidateItem constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return this.itemRepository.findByName(s).isEmpty();
    }
}
