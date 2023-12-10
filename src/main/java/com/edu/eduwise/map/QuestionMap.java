package com.edu.eduwise.map;

import com.edu.eduwise.dto.ExamResultDto;
import com.edu.eduwise.dto.QuestionDto;
import com.edu.eduwise.model.Exam;
import com.edu.eduwise.model.ExamResult;
import com.edu.eduwise.model.Question;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface QuestionMap {

    @Mapping(target = "examId",expression = "java(toSet(question.getExam()))")
    QuestionDto toDto(Question question);

    @Mapping(target = "exam",ignore = true)
    @Mapping(target = "id", ignore = true)
    Question toEntity (QuestionDto questionDto);


    @Mapping(target = "exam", ignore = true)
    @Mapping(target = "id", ignore = true)
    void updateEntityFromDto(@MappingTarget() Question question, QuestionDto questionDto);

    default Long toSet(Exam exam){
        return exam.getId();
    }
}
