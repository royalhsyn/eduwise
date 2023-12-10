package com.edu.eduwise.dto;

import com.edu.eduwise.model.Category;
import com.edu.eduwise.valid.CategoryExists;
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
public class UserDto {

    private String username;

    private LocalDate registrationDate;

    @CategoryExists
    private Long categoryId;
}
