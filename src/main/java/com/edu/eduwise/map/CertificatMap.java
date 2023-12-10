package com.edu.eduwise.map;

import com.edu.eduwise.dto.CertificatDto;
import com.edu.eduwise.dto.CourseDto;
import com.edu.eduwise.model.Certificat;
import com.edu.eduwise.model.Course;
import com.edu.eduwise.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CertificatMap {

    @Mapping(target = "userId", expression = "java(toSet(certificat.getUser()))")
    CertificatDto toDto(Certificat certificat);

    @Mapping(target = "user",ignore = true)
    @Mapping(target = "course",ignore = true)
    @Mapping(target = "id",ignore = true)
    Certificat toEntity(CertificatDto certificatDto);

    @Mapping(target = "user", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "course", ignore = true)
    void updateEntityFromDto(@MappingTarget() Certificat certificat, CertificatDto certificatDto);

    default Long toSet(User user){
        return user.getId();
    }
}
