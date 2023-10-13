package com.example.weather.controller;

import com.example.weather.dto.request.WeatherRqDTO;
import com.example.weather.dto.response.WeatherHistoryResDTO;
import com.example.weather.dto.response.WeatherResDTO;
import com.example.weather.exception.TechnicalException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;


@Api(value = "/current", description = "Controlador para manejar las operaciones relacionadas con la información meteorológica actual.")
public interface WeatherCurrentController {

    @ApiOperation(value = "Obtiene la información meteorológica actual basada en la clave de ubicación proporcionada.",
            httpMethod = "POST",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200,
                    message = "La información meteorológica actual se ha recuperado exitosamente.",
                    response = WeatherResDTO.class),
            @ApiResponse(code = 500,
                    message = "Error tecnico generico",
                    response = TechnicalException.class)})
    ResponseEntity<WeatherResDTO> getCurrentByLocationKey(WeatherRqDTO rq) throws TechnicalException;

    @ApiOperation(value = "Obtiene el historial de información meteorológica actual consultadas.",
            httpMethod = "GET",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200,
                    message = "El historial se ha recuperado exitosamente.",
                    response = WeatherHistoryResDTO.class),
            @ApiResponse(code = 500,
                    message = "Error tecnico generico",
                    response = TechnicalException.class)})
    ResponseEntity<WeatherHistoryResDTO> getWeatherCurrentHistory() throws TechnicalException;
}
