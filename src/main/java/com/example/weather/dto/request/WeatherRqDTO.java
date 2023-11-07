package com.example.weather.dto.request;


import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WeatherRqDTO {
    @ApiModelProperty(notes = "Clave única que identifica la ubicación para obtener información meteorológica", required = true)
    String key;
}
