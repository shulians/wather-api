package com.example.weather.controller;

import com.example.weather.dto.request.WeatherRqDTO;
import com.example.weather.dto.response.WeatherHistoryResDTO;
import com.example.weather.dto.response.WeatherResDTO;
import com.example.weather.exception.TechnicalException;

import io.swagger.annotations.*;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;


@Api(value = "/current",tags = {"Weather - Service"}, description = "Servicio para gestionar información meteorológica actual de una ubicacion.")
public interface WeatherCurrentController {

    @ApiOperation(value = "Obtiene la información meteorológica actual basada en la clave de ubicación proporcionada.",
            httpMethod = "POST",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200,
                    message = "success",
                    response = WeatherResDTO.class),
            @ApiResponse(code = 500,
                    message = "Internal Server Error")})
    ResponseEntity<WeatherResDTO> getCurrentByLocationKey(WeatherRqDTO rq) throws TechnicalException;


    @ApiOperation(value = "Obtiene el historial de información meteorológica actual consultadas.",
            httpMethod = "GET",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200,
                    message = "success",
                    response = WeatherHistoryResDTO.class),
            @ApiResponse(code = 500,
                    message = "Internal Server Error")})
    ResponseEntity<WeatherHistoryResDTO> getWeatherCurrentHistory() throws TechnicalException;
}
