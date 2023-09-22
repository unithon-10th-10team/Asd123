package com.example.deokjideokji.config.swagger;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {
        Info info = new Info()
                .title("Basic Project Form")
                .version("v0.0.1")
                .description("기본 프로젝트 폼 생성");

        return new OpenAPI()
                .info(info);
    }
}
