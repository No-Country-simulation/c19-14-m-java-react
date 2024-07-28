package com.example.appAdopcionDeMascota.controller;

import com.example.appAdopcionDeMascota.dto.AuthCreateUserRequest;
import com.example.appAdopcionDeMascota.dto.AuthLoginRequest;
import com.example.appAdopcionDeMascota.dto.AuthLoginResponse;
import com.example.appAdopcionDeMascota.dto.AuthRegisterResponse;
import com.example.appAdopcionDeMascota.service.interfaceServ.IAuthServcivce;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api/v1/auth")
@Slf4j
public class AuthController {

    private final IAuthServcivce authServcivce;

    @PostMapping(value = "/register")
    public ResponseEntity<AuthRegisterResponse> register(@RequestBody @Valid AuthCreateUserRequest createUserRequest) {
        return new ResponseEntity<>(this.authServcivce.createUser(createUserRequest), HttpStatus.CREATED);
    }



    @PostMapping("/login")
    public ResponseEntity<AuthLoginResponse> login(@RequestBody @Valid AuthLoginRequest loginUserRequest) {
        return new ResponseEntity<>(this.authServcivce.loginUser(loginUserRequest), HttpStatus.OK);
    }



}


