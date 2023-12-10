package com.edu.eduwise.repo;

import com.edu.eduwise.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepo extends JpaRepository<Course,Long> {
}
