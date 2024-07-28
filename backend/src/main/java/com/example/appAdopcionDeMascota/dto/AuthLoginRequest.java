package com.example.appAdopcionDeMascota.dto;

import jakarta.validation.constraints.NotBlank;

public record AuthLoginRequest(@NotBlank String userEmail,
                               @NotBlank String password) {
}
