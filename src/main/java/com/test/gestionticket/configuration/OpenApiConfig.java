package com.test.gestionticket.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;

public class OpenApiConfig {
    @Bean
    public OpenAPI defineOpenApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("API Gestion de tickets")
                        .description("API la gestion de tickets")
                        .version("v1"));
    }
}
