package com.edu.eduwise.dto;

import com.edu.eduwise.model.Course;
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
public class ExamDto {

    private String name;

    private LocalDate examDate;

    private Long durationMinutes;

    private Long totalMarks;

    private String description;

    private Long courseId;

}
