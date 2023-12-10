package com.edu.eduwise.valid;

import com.edu.eduwise.service.EntityExistenceService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class CategoryExistsValidator implements ConstraintValidator<CategoryExists, Long> {
    @Autowired
    private EntityExistenceService entityExistenceService;

    @Override
    public boolean isValid(Long categoryId, ConstraintValidatorContext context) {
        if (categoryId == null) {
            return false;
        }

        return entityExistenceService.doesCategoryExist(categoryId);
    }
}
