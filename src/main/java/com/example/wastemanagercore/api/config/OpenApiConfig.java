package com.example.wastemanagercore.api.config;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@Configuration
@OpenAPIDefinition(info = @Info(title = "Main API for Waste Manager", version = "1.0.0", description = "This API privides the CRUD operations for Waste Manager"))
public class OpenApiConfig {

}
