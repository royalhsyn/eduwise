package com.edu.eduwise.dto;

import com.edu.eduwise.model.Exam;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SubCategoryDto {

    private String name;

    private String description;

    private Long examId;
}
