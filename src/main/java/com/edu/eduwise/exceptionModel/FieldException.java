package com.edu.eduwise.exceptionModel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class FieldException {
    private String path;
    private String msg;
}
