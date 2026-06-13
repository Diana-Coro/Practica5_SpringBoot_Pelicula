package com.diana.practica5.practica5.Config;

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
                        .title("API REST - Gestión de Películas")
                        .version("1.0.0")
                        .description("""
                                PRACTICA 5 - BACKEND SPRING BOOT
                                
                                -Estudiante: Diana Coro Llave 

                                -Carrera: Ingeniería de Sistemas

                                -Materia: Tecnologías Emergentes SIS-414 Grupo 2
                                
                                -Universidad Autónoma Tomás Frías
                                
                                
                                """));
    }
}