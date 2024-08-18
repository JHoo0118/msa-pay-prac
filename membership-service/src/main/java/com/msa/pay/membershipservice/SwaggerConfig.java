package com.msa.pay.membershipservice;

import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.info.Info;
import lombok.RequiredArgsConstructor;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;

@Configuration
@RequiredArgsConstructor
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Membership API")
                        .version("1.0")
                        .description("Membership API Documentation"));
    }
}