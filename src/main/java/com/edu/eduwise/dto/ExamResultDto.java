package com.edu.eduwise.dto;

import com.edu.eduwise.model.Exam;
import com.edu.eduwise.model.User;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ExamResultDto {

    private Double obtainedMarks;

    private Long totalMarks;

    private Long examId ;

    private Long userId;
}
