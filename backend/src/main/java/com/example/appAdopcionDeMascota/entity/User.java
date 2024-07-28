package com.example.appAdopcionDeMascota.entity;


import com.example.appAdopcionDeMascota.utils.Estado;
import com.example.appAdopcionDeMascota.utils.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuarios")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "apellido", nullable = false)
    private String apellido;

    @Column(name = "imagen")
    private String imagen_url;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "edad")
    private Integer edad;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "status", nullable = false)
    private String status;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "direccion_id")
    private Direccion direccion;

    private Role role;
}
