package com.example.appAdopcionDeMascota.repository;

import com.example.appAdopcionDeMascota.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByEmail(String email);
}
