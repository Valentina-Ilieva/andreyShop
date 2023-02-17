package com.example.andreyshop.services;

import com.example.andreyshop.domein.entities.Category;
import com.example.andreyshop.domein.enums.CategoryName;
import com.example.andreyshop.domein.models.CategoryModel;
import com.example.andreyshop.repositories.CategoryRepository;
import jakarta.annotation.PostConstruct;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }

    @PostConstruct
    private void postConstruct() {
        if (this.categoryRepository.count() == 0) {
            this.categoryRepository.saveAllAndFlush(Arrays.stream(CategoryName.values())
                    .map(enumValues -> CategoryModel.builder()
                            .name(enumValues)
                            .description("buy me")
                            .build())
                    .map(categoryModel -> this.modelMapper.map(categoryModel, Category.class))
                    .toList());


        }
    }

    public CategoryModel findByName(CategoryName name) {
        return this.modelMapper.map(this.categoryRepository.findByName(name).orElseThrow(), CategoryModel.class);
    }
}
