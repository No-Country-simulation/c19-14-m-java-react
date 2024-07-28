package com.example.appAdopcionDeMascota.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class UserException extends RuntimeException{

    private final String mensaje;
    private final HttpStatus statusCode;

    public UserException(String mensaje, HttpStatus statusCode) {
        super(mensaje);
        this.mensaje = mensaje;
        this.statusCode = statusCode;
    }

    public UserException(String mensaje) {
        super(mensaje);
        this.mensaje = mensaje;
        this.statusCode = null;

    }
}
