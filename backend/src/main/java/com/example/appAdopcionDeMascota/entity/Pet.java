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
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer age;
    private String race;
    private String description;
    private String photo;
    private String type;

    @OneToMany(mappedBy = "pet", cascade = CascadeType.ALL)
    private List<Vaccine> vaccines;

    @OneToOne(mappedBy = "pet")
    private AdoptionPet adoptionPet;

    @OneToOne(mappedBy = "pet")
    private OfferPet offerPet;
}
