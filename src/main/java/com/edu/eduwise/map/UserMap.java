package com.edu.eduwise.map;

import com.edu.eduwise.dto.RegistrationDto;
import com.edu.eduwise.dto.UserDto;
import com.edu.eduwise.model.Category;
import com.edu.eduwise.model.User;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.UUID;

@Mapper(imports = UUID.class,componentModel = "spring")
public abstract class UserMap {

    @Lazy
    @Autowired
    protected PasswordEncoder encoder;

    @Mapping(target = "categoryId", expression = "java(toSet(user.getCategory()))")
    public abstract UserDto toDto(User user);


    @Mapping(target = "uuid", ignore = true)
    @Mapping(target = "roles", ignore = true)
    @Mapping(target = "messages",ignore = true)
    @Mapping(target = "examResults",ignore = true)
    @Mapping(target = "enabled", ignore = true)
    @Mapping(target = "credentialsNonExpired", ignore = true)
    @Mapping(target = "certificats", ignore = true)
    @Mapping(target = "category", ignore = true)
    @Mapping(target = "attemptCount", ignore = true)
    @Mapping(target = "accountNonLocked", ignore = true)
    @Mapping(target = "accountNonExpired", ignore = true)
    @Mapping(target = "id", ignore = true)
    public abstract User toEntity(UserDto userDto);


    @Mapping(target = "roles", ignore = true)
    @Mapping(target = "registrationDate", ignore = true)
    @Mapping(target = "messages", ignore = true)
    @Mapping(target = "examResults", ignore = true)
    @Mapping(target = "email", ignore = true)
    @Mapping(target = "certificats", ignore = true)
    @Mapping(target = "attemptCount", ignore = true)
    @Mapping(target = "category", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "enabled", constant = "false")
    @Mapping(target = "credentialsNonExpired", constant = "true")
    @Mapping(target = "accountNonLocked", constant = "true")
    @Mapping(target = "accountNonExpired", constant = "true")
    @Mapping(target = "password", expression = "java(encoder.encode(dto.getPassword()))")
    @Mapping(target = "uuid", expression = "java(UUID.randomUUID())")
    public abstract User toEntity(RegistrationDto dto);




    @Mapping(target = "roles", ignore = true)
    @Mapping(target = "messages", ignore = true)
    @Mapping(target = "uuid",ignore = true)
    @Mapping(target = "examResults", ignore = true)
    @Mapping(target = "certificats",ignore = true)
    @Mapping(target = "credentialsNonExpired", ignore = true)
    @Mapping(target = "enabled", ignore = true)
    @Mapping(target = "attemptCount",ignore = true)
    @Mapping(target = "accountNonLocked", ignore = true)
    @Mapping(target = "accountNonExpired", ignore = true)
    @Mapping(target = "id", ignore = true)
    public abstract void updateEntityFromDto(@MappingTarget() User user, UserDto userDto);



    public Long toSet(Category category){
        return category.getId();
    }


}
