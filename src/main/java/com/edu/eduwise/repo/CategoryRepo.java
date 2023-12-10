package com.edu.eduwise.repo;

import com.edu.eduwise.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category,Long> {
}
