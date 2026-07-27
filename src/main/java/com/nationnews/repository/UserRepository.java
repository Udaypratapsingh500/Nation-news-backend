package com.nationnews.repository;

import com.nationnews.entity.Role;
import com.nationnews.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);

    // Dashboard Statistics
    long countByRole(Role role);
}