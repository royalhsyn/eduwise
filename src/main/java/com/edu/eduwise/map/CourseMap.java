package com.edu.eduwise.map;

import com.edu.eduwise.dto.CourseDto;
import com.edu.eduwise.model.Certificat;
import com.edu.eduwise.model.Course;
import com.edu.eduwise.model.Orders;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CourseMap {

    @Mapping(target = "certificatId",expression = "java(toSet(course.getCertificat()))")
    @Mapping(target = "ordersId",expression = "java(toSetOrders(course.getOrders()))")
    CourseDto toDto(Course course);


    @Mapping(target = "images", ignore = true)
    @Mapping(target = "exams", ignore = true)
    @Mapping(target = "id",ignore = true)
    Course toEntity(CourseDto courseDto);



    @Mapping(target = "images", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "exams", ignore = true)
    void updateEntityFromDto(@MappingTarget() Course course, CourseDto courseDto);

    default Long toSet(Certificat certificat){
        return certificat.getId();
    }

    default Long toSetOrders(Orders orders){
        return orders.getId();
    }
}
