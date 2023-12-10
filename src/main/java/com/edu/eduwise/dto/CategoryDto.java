package com.edu.eduwise.dto;

import com.edu.eduwise.model.Category;
import com.edu.eduwise.valid.DescriptionConstraint;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CategoryDto {

    private String name;

    @DescriptionConstraint
    private String description;

    private Long subCategoryId;
}
