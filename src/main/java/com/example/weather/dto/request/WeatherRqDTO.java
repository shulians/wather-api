package com.example.weather.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WeatherRqDTO {
    @Schema(description = "Clave única que identifica la ubicación para obtener información meteorológica", required = true)
    String key;
}
