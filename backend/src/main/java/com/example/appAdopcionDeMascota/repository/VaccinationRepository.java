package com.example.appAdopcionDeMascota.repository;

import com.example.appAdopcionDeMascota.entity.Vaccine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VaccinationRepository extends JpaRepository<Vaccine, Long> {
}
