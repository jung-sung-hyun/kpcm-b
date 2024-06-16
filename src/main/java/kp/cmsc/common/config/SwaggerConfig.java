package kp.cmsc.common.config;


import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI komscoOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("관리자 공통 프로그램")
                        .version("1.0")
                        .description("공통으로 사용되는 프로그램을 기술하고 개발자에게 제공한다.")
                        .contact(new Contact()
                                .name("조폐공사")
                                .url("http://localhost:8090/")
                                .email("master@komsco.go.kr")));
    }

    @Bean
    public GroupedOpenApi adminApi() {
        return GroupedOpenApi.builder()
                .group("관리자")
                .packagesToScan("kp.cmsc.cmsc01")
                .build();
    }

    @Bean
    public GroupedOpenApi pilotApi() {
        return GroupedOpenApi.builder()
                .group("파일럿")
                .packagesToScan("kp.cmsc.cmsc98")
                .build();
    }
}