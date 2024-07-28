package com.example.appAdopcionDeMascota.service.interfaceServ;

import com.example.appAdopcionDeMascota.dto.AuthCreateUserRequest;
import com.example.appAdopcionDeMascota.dto.AuthLoginRequest;
import com.example.appAdopcionDeMascota.dto.AuthLoginResponse;
import com.example.appAdopcionDeMascota.dto.AuthRegisterResponse;

public interface IAuthServcivce {
     AuthRegisterResponse createUser(AuthCreateUserRequest createUserRequest);

    AuthLoginResponse loginUser(AuthLoginRequest loginUserRequest);
}
