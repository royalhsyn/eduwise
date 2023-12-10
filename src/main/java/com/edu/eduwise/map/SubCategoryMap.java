package com.edu.eduwise.map;

import com.edu.eduwise.dto.SubCategoryDto;
import com.edu.eduwise.model.Exam;
import com.edu.eduwise.model.SubCategory;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface SubCategoryMap {


    @Mapping(target = "examId",expression = "java(toSet(subCategory.getExam()))")
    SubCategoryDto toDto(SubCategory subCategory);


    @Mapping(target = "exam", ignore = true)
    @Mapping(target = "categoryList", ignore = true)
    @Mapping(target = "id", ignore = true)
    SubCategory toEntity(SubCategoryDto subCategoryDto);

    @Mapping(target = "exam",ignore = true)
    @Mapping(target = "categoryList", ignore = true)
    @Mapping(target = "id", ignore = true)
    void updateEntityFromDto(@MappingTarget() SubCategory subCategory, SubCategoryDto subCategoryDto);

    default Long toSet(Exam exam){
        return exam.getId();
    }
}
