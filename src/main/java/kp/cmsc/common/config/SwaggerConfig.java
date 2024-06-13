package kp.cmsc.common.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.media.Schema;
import lombok.RequiredArgsConstructor;
@OpenAPIDefinition(
        info = @Info(title = "Kpcm-Service 공통 API 명세서",
                description = "사용자 공통 서비스 API 명세서",
                version = "v1"))
@RequiredArgsConstructor
@Configuration
public class SwaggerConfig {
    Schema<Object> customMapBody = new Schema<Object>();
    @Bean
    OpenAPI openAPI() {
        return new OpenAPI().components(new Components().addSchemas("CustomMapBody", customMapBody));
    }

//    @Bean
//    OpenAPI openAPI() {
//        return new OpenAPI();
//    }

}