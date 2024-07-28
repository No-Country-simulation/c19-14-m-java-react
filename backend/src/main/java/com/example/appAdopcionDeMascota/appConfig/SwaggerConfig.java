package com.example.appAdopcionDeMascota.appConfig;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Adopción de Mascotas")
                        .version("1.0")
                        .description("Documentación de la API de Adopción de Mascotas"));
    }
}

