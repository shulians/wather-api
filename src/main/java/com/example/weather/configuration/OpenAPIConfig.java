package com.example.weather.configuration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//import io.swagger.v3.oas.models.OpenAPI;
//import io.swagger.v3.oas.models.info.Info;
//import io.swagger.v3.oas.models.servers.Server;

//@Configuration
public class OpenAPIConfig {
    //@Value("${openapi.dev-url}")
    String devUrl;

    /*@Bean
    public OpenAPI myOpenAPI() {
        Server devServer = new Server();
        devServer.setUrl(devUrl);
        devServer.setDescription("Server URL in Local environment");

        List<Server> ls = new ArrayList<>();
        ls.add(devServer);

        Info info = new Info()
                .title("Servicio de Clima")
                .version("1.0")
                .description("Este microservicio utiliza la API pública de AccuWeather para obtener información del clima y guarda los resultados en una base de datos H2.");

        return new OpenAPI().info(info).servers(ls);
    }*/
}
