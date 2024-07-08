package com.example.appAdopcionDeMascota.repository;

import com.example.appAdopcionDeMascota.entity.History;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryRepository extends JpaRepository<History, Long> {
}
