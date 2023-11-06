package com.example.weather.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.BasicAuth;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                //.securitySchemes(generateSecurityScheme())
                .apiInfo(apiInfo())
                .useDefaultResponseMessages(false)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.weather.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private List<SecurityScheme> generateSecurityScheme() {
        List<SecurityScheme> schemeList = new ArrayList<>();
        BasicAuth basicAuth = new BasicAuth("basicAuth");
        schemeList.add(basicAuth);
        return schemeList;
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("API - Statistics and Reports service")
                .description("Service to create statistics and reports from PSR")
                .version("1.0.0")
                .build();
    }

}
