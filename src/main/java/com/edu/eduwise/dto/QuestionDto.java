package com.edu.eduwise.dto;

import com.edu.eduwise.model.Exam;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class QuestionDto {

    private LocalDate durationMinutes;

    private Long totalMarks;

    private String description;

    private Long examId;
}
