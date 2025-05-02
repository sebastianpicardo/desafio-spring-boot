package com.sp.api_spa.Config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
    info = @Info(
        title = "API de gestión usuarios y tareas",
        version = "1.0",
        description = "Documentación de la API para gestión usuarios y tareas. Prueba técnica sebastián picardo"
    )
)

public class OpenAPIConfig {
}