package com.example.appAdopcionDeMascota.repository;

import com.example.appAdopcionDeMascota.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
