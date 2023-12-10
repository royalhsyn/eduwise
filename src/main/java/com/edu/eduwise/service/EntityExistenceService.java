package com.edu.eduwise.service;

import com.edu.eduwise.repo.CategoryRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EntityExistenceService {

    private final CategoryRepo categoryRepo;




    public boolean doesCategoryExist(Long categoryId) {
        return categoryRepo.existsById(categoryId);
    }
}
