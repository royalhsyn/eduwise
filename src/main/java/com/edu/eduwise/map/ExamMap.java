package com.edu.eduwise.map;

import com.edu.eduwise.dto.CourseDto;
import com.edu.eduwise.dto.ExamDto;
import com.edu.eduwise.model.Course;
import com.edu.eduwise.model.Exam;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ExamMap {

    @Mapping(target = "courseId",expression = "java(toSetCourse(exam.getCourse()))")
    ExamDto toDto(Exam exam);

    @Mapping(target = "subCategories",ignore = true)
    @Mapping(target = "questionList", ignore = true)
    @Mapping(target = "examResults", ignore = true)
    @Mapping(target = "course", ignore = true)
    @Mapping(target = "id",ignore = true)
    Exam toEntity(ExamDto examDto);

    @Mapping(target = "course",ignore = true)
    @Mapping(target = "subCategories", ignore = true)
    @Mapping(target = "questionList", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "examResults", ignore = true)
    void updateEntityFromDto(@MappingTarget() Exam exam, ExamDto examDto);

    default Long toSetCourse(Course course){
        return course.getId();
    }
}
