package com.edu.eduwise.repo;

import com.edu.eduwise.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepo extends JpaRepository<User, Long> {

    Optional<User> findByUuid(UUID uuid);

    Optional<User> findByUsername(String username);

    boolean existsByEmail(String email);
}
