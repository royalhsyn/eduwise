package com.edu.eduwise.service;

import com.edu.eduwise.dto.CourseDto;
import com.edu.eduwise.exception.NotFoundException;
import com.edu.eduwise.map.CourseMap;
import com.edu.eduwise.model.Certificat;
import com.edu.eduwise.model.Course;
import com.edu.eduwise.model.Orders;
import com.edu.eduwise.repo.CertificatRepo;
import com.edu.eduwise.repo.CourseRepo;
import com.edu.eduwise.repo.OrdersRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepo courseRepo;

    private final CourseMap courseMap;

    private final OrdersRepo ordersRepo;

    private final CertificatRepo certificatRepo;

    public CourseDto findById(Long id){
        return courseRepo.findById(id)
                .map(courseMap::toDto)
                .orElseThrow(()-> new NotFoundException("Bele id li user yoxdur"));
    }

    public List<CourseDto> list(){
        return courseRepo.findAll()
                .stream()
                .map(courseMap::toDto)
                .toList();
    }

    public void save(CourseDto courseDto){
        Course course=courseMap.toEntity(courseDto);
        Optional<Orders> orders=ordersRepo.findById(courseDto.getOrdersId());
        Optional<Certificat> certificat=certificatRepo.findById(courseDto.getCertificatId());
        if(orders.isPresent() && certificat.isPresent()){
            course.setOrders(orders.get());
            course.setCertificat(certificat.get());
        }
        courseRepo.save(course);
    }

    public void update(Long id,CourseDto courseDto){
        Optional<Course> ent=courseRepo.findById(id);
        Course course=null;
        if(ent.isPresent()){
            course=ent.get();
        }
        Optional<Orders> orders=ordersRepo.findById(courseDto.getOrdersId());
        Optional<Certificat> certificat=certificatRepo.findById(courseDto.getCertificatId());
        if(orders.isPresent() && certificat.isPresent()){
            course.setOrders(orders.get());
            course.setCertificat(certificat.get());
        }
        courseMap.updateEntityFromDto(course,courseDto);
        courseRepo.save(course);

    }
}
