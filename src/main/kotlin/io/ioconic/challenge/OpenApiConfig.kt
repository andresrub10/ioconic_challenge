package io.ioconic.challenge;

import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Bean
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info


class OpenApiConfig {
    

    fun usersMicroserviceOpenAPI(): OpenAPI {
        return OpenAPI().info(Info().title("Your API Title").description("Your API Description").version("1.0"))
    }
}
