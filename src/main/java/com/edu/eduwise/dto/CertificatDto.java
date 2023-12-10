package com.edu.eduwise.dto;

import com.edu.eduwise.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CertificatDto {

    private LocalDate issueDate;

    private Long userId;
}
