package com.edu.eduwise.util;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ImageUploadResponse {

    private String message;
    
    private HttpStatus httpStatus;
    
    private LocalDateTime updateTime;



}
