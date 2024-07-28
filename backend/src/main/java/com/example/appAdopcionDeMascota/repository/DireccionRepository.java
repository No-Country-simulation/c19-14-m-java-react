package com.example.appAdopcionDeMascota.repository;

import com.example.appAdopcionDeMascota.entity.Direccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DireccionRepository extends JpaRepository<Direccion , Long> {
}
