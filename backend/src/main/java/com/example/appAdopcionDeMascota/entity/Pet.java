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
    private String type;
    private Integer age;
    private String race;
    private String gender;
    private String color;
    private Float weight;
    private String description;
    private String photo;
    private Boolean isAvailable;

    @OneToMany(mappedBy = "pet", cascade = CascadeType.ALL)
    private List<Vaccine> vaccines;

    @OneToMany(mappedBy = "pet", cascade = CascadeType.ALL)
    private List<AdoptionPet> adoptionPets;

    @OneToMany(mappedBy = "pet", cascade = CascadeType.ALL)
    private List<OfferPet> offerPets;
}
