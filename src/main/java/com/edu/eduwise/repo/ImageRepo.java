package com.edu.eduwise.repo;

import com.edu.eduwise.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ImageRepo extends JpaRepository<Image,Long> {
    Optional<Image> findByName(String name);
}
