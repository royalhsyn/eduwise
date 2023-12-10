package com.edu.eduwise.controller;

import com.edu.eduwise.dto.CourseDto;
import com.edu.eduwise.response.BaseResponse;
import com.edu.eduwise.service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/course")
public class CourseController {

    private final CourseService courseService;

    @GetMapping
    public List<CourseDto> list(){
        return courseService.list();
    }

    @GetMapping("/{id}")
    public CourseDto findById(@PathVariable(name = "id") Long id){
        return courseService.findById(id);
    }

    @PostMapping
    public BaseResponse<Object> save(@Valid @RequestBody CourseDto courseDto){
        courseService.save(courseDto);
        return BaseResponse.succes(courseDto);
    }

    @PutMapping("/{id}")
    public BaseResponse<Object> update(@PathVariable(name = "id") Long id,@Valid @RequestBody CourseDto courseDto){
        courseService.update(id,courseDto);
        return BaseResponse.builder().message("Product updated succesfully!").status(HttpStatus.OK).build();
    }
}
