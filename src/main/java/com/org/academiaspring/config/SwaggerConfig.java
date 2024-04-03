package com.org.academiaspring.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    private static final String API_TITLE = "Academia Spring API";
    private static final String API_DESCRIPTION = "Documentação da API da Academia Spring Api";
    private static final String API_VERSION = "1.0.0";

    @Bean
    public OpenAPI openApi() {
        return new OpenAPI().info(new Info().title(API_TITLE).description(API_DESCRIPTION).version(API_VERSION));
    }
}
