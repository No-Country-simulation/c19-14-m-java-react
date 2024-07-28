package com.example.appAdopcionDeMascota.dto;

import com.example.appAdopcionDeMascota.entity.Direccion;
import com.example.appAdopcionDeMascota.utils.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AuthCreateUserRequest (@NotBlank String nombre,
                                     @NotBlank String apellido,
                                     @NotBlank String username,
                                     @NotBlank String telefono,
                                     @NotNull Integer edad,
                                     @NotBlank @Email String email,
                                     @NotBlank String password,
                                     @NotNull Direccion direccion,
                                     @NotNull Role role){}
