package com.example.appAdopcionDeMascota.repository;

import com.example.appAdopcionDeMascota.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet, Long> {
}
