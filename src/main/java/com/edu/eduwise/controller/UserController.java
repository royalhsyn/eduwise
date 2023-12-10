package com.edu.eduwise.controller;

import com.edu.eduwise.dto.UserDto;
import com.edu.eduwise.model.User;
import com.edu.eduwise.repo.UserRepo;
import com.edu.eduwise.response.BaseResponse;
import com.edu.eduwise.service.UserService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RequiredArgsConstructor
@RestController
@SecurityRequirement(name = "bearerAuth")
@RequestMapping("/api/v1/user")
public class UserController {


    private final UserService userService;

    @GetMapping("/{id}")
    public UserDto findById(@PathVariable(name = "id") Long id){
        return userService.findById(id);
    }

    @GetMapping
    public List<UserDto> list(){
        return userService.list();
    }

    @PostMapping
    public BaseResponse<Object> save(@Valid @RequestBody UserDto userDto){
        userService.save(userDto);
        return BaseResponse.succes(userDto);
    }

    @PutMapping("/{id}")
    public BaseResponse<Object> update(@PathVariable(name = "id") Long id,@Valid @RequestBody UserDto userDto){
        userService.update(id,userDto);
        return BaseResponse.builder().message("Product updated succesfully!").status(HttpStatus.OK).build();
    }
}
