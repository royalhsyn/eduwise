package com.edu.eduwise.map;

import com.edu.eduwise.dto.CategoryDto;
import com.edu.eduwise.dto.CourseDto;
import com.edu.eduwise.model.Category;
import com.edu.eduwise.model.Course;
import com.edu.eduwise.model.SubCategory;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CategoryMap {

    @Mapping(target = "subCategoryId", expression = "java(toSet(category.getSubCategory()))")
    CategoryDto toDto(Category category);

    @Mapping(target = "users", ignore = true)
    @Mapping(target = "subCategory",ignore = true)
    @Mapping(target = "id",ignore = true)
    Category toEntity(CategoryDto categoryDto);

    @Mapping(target = "subCategory",ignore = true)
    @Mapping(target = "users",ignore = true)
    @Mapping(target = "id", ignore = true)
    void updateEntityFromDto(@MappingTarget() Category category, CategoryDto categoryDto);

    default Long toSet(SubCategory subCategory){
        return subCategory.getId();
    }
}
