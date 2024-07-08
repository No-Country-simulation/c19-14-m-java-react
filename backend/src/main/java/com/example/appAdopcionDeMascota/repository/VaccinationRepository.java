package com.example.appAdopcionDeMascota.repository;

import com.example.appAdopcionDeMascota.entity.Vaccination;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VaccinationRepository extends JpaRepository<Vaccination, Long> {
}
