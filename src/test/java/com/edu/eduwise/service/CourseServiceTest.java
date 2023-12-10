package com.edu.eduwise.service;

import com.edu.eduwise.dto.CourseDto;
import com.edu.eduwise.map.CourseMap;
import com.edu.eduwise.model.Certificat;
import com.edu.eduwise.model.Course;
import com.edu.eduwise.model.Orders;
import com.edu.eduwise.repo.CertificatRepo;
import com.edu.eduwise.repo.CourseRepo;
import com.edu.eduwise.repo.OrdersRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;


public class CourseServiceTest {

    @Mock
    private CourseRepo repo;
    @Mock private CourseMap map;
    @Mock private OrdersRepo ordersRepo;
    @Mock private CertificatRepo certificatRepo;

    @InjectMocks
    private CourseService service;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void findByIdCourseDtoIdExists() {
        Long id = 1L;
        Course course = new Course();
        CourseDto dto = new CourseDto();

        when(repo.findById(id)).thenReturn(Optional.of(course));
        when(map.toDto(course)).thenReturn(dto);

        CourseDto result = service.findById(id);

        assertNotNull(result);
        verify(repo, times(1)).findById(id);
        verify(map, times(1)).toDto(course);
    }



    @Test
    public void listCourseDtoCoursesExist() {
        Course course1 = new Course();
        Course course2 = new Course();
        CourseDto dto1 = new CourseDto();
        CourseDto dto2 = new CourseDto();

        when(repo.findAll()).thenReturn(Arrays.asList(course1, course2));
        when(map.toDto(course1)).thenReturn(dto1);
        when(map.toDto(course2)).thenReturn(dto2);

        List<CourseDto> result = service.list();

        assertEquals(2, result.size());
        verify(repo, times(1)).findAll();
        verify(map, times(2)).toDto(any());
    }

    @Test
    public void saveCourseOrdersAndCertificatIdExist() {
        CourseDto dto = new CourseDto();
        dto.setOrdersId(1L);
        dto.setCertificatId(2L);
        Course course = new Course();
        Orders orders = new Orders();
        Certificat certificat = new Certificat();

        when(ordersRepo.findById(dto.getOrdersId())).thenReturn(Optional.of(orders));
        when(certificatRepo.findById(dto.getCertificatId())).thenReturn(Optional.of(certificat));
        when(map.toEntity(dto)).thenReturn(course);

        service.save(dto);

        verify(repo).save(course);
    }


}
