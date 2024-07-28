package com.example.appAdopcionDeMascota.dto;

import com.example.appAdopcionDeMascota.entity.Direccion;
import com.example.appAdopcionDeMascota.utils.Role;

public record AuthRegisterResponse(Long userId,
                                   String nombre,
                                   String apellido,
                                   String imagenUrl,
                                   String username,
                                   String telefono,
                                   Integer edad,
                                   String email,
                                   String status,
                                   Direccion direccion,
                                   Role role,
                                   String token) {
}
