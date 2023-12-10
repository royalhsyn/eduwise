package com.edu.eduwise.map;

import com.edu.eduwise.dto.PermissionDto;
import com.edu.eduwise.model.Permission;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PermissionMap {

    PermissionDto toDto(Permission permission);

    @Mapping(target = "id", ignore = true)
    Permission toEntity(PermissionDto permissionDto);
}
