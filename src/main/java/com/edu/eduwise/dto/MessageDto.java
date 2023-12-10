package com.edu.eduwise.dto;

import com.edu.eduwise.model.User;
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
public class MessageDto {

    private String messageText;

    private LocalDate sendAt;

    private Boolean isRead;

    private Long userId;
}
