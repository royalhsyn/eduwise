package com.edu.eduwise.map;

import com.edu.eduwise.dto.RoleDto;
import com.edu.eduwise.model.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RoleMap {

    RoleDto toDto(Role role);

    @Mapping(target = "permissions",ignore = true)
    @Mapping(target = "id", ignore = true)
    Role toEntity(RoleDto roleDto);

}
