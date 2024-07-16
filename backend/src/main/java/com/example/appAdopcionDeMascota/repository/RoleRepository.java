package com.example.appAdopcionDeMascota.repository;

import com.example.appAdopcionDeMascota.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
