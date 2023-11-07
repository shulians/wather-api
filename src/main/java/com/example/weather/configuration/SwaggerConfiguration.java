package com.example.weather.configuration;

import io.swagger.annotations.Tag;
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
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger.web.UiConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
    @Bean
    public Docket api() throws ClassNotFoundException {
        return new Docket(DocumentationType.SWAGGER_2)
                //.securitySchemes(generateSecurityScheme())
                .apiInfo(apiInfo())
                .useDefaultResponseMessages(false)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.weather.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    @Bean
    public UiConfiguration uiConfig() {
        return UiConfigurationBuilder.builder()
                .defaultModelsExpandDepth(-1)
                .build();
    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("API - Servicio de Clima")
                .description("Este microservicio utiliza la API pública de AccuWeather para obtener información del clima y guarda los resultados en una base de datos H2.")
                .version("1.0.0")
                .build();
    }

    private List<SecurityScheme> generateSecurityScheme() {
        List<SecurityScheme> schemeList = new ArrayList<>();
        BasicAuth basicAuth = new BasicAuth("basicAuth");
        schemeList.add(basicAuth);
        return schemeList;
    }

}
