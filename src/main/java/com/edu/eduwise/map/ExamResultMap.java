package com.edu.eduwise.map;

import com.edu.eduwise.dto.ExamDto;
import com.edu.eduwise.dto.ExamResultDto;
import com.edu.eduwise.model.Exam;
import com.edu.eduwise.model.ExamResult;
import com.edu.eduwise.model.SubCategory;
import com.edu.eduwise.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ExamResultMap {

    @Mapping(target = "examId",expression = "java(toSet(examResult.getExam()))")
    @Mapping(target = "userId",expression = "java(toSetUser(examResult.getUser()))")
    ExamResultDto toDto(ExamResult examResult);

    @Mapping(target = "user", ignore = true)
    @Mapping(target = "exam", ignore = true)
    @Mapping(target = "id", ignore = true)
    ExamResult toEntity(ExamResultDto examResultDto);

    @Mapping(target = "user", ignore = true)
    @Mapping(target = "exam", ignore = true)
    @Mapping(target = "id", ignore = true)
    void updateEntityFromDto(@MappingTarget() ExamResult examResult, ExamResultDto examResultDto);

    default Long toSet(Exam exam){
        return exam.getId();
    }

    default Long toSetUser(User user){
        return user.getId();
    }
}
