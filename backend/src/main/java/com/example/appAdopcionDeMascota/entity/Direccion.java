package com.example.appAdopcionDeMascota.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "direciones")
public class Direccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long direccion_id;

    @Column(name = "provincia", nullable = false)
    private String provincia;

    @Column(name = "calle", nullable = false)
    private String calle;

    @Column(name = "altura", nullable = false)
    private String altura;

    @Column(name = "ciudad", nullable = false)
    private String ciudad;

    @Column(name = "estado", nullable = false)
    private String estado;

    @Column(name = "codigo_postal", nullable = false)
    private String codigoPostal;

}
