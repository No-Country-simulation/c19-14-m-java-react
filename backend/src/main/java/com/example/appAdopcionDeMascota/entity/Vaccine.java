package com.example.appAdopcionDeMascota.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vaccine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalDate applicationDate;
    private String description;

    @ManyToOne
    @JoinColumn(name = "pet_id", nullable = false)
    private Pet pet;
}
