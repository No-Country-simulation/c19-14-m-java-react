package com.example.appAdopcionDeMascota.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private String weight;

    @OneToOne(mappedBy = "history", cascade = CascadeType.ALL, fetch = FetchType.LAZY )
    private Pet pet;

    @OneToMany(mappedBy = "history", cascade = CascadeType.ALL, fetch = FetchType.LAZY )
    private List<Vaccination> vaccination;
}
