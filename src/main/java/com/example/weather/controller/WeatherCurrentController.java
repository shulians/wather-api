package com.example.weather.controller;

import com.example.weather.dto.request.WeatherRqDTO;
import com.example.weather.dto.response.WeatherHistoryResDTO;
import com.example.weather.dto.response.WeatherResDTO;
import com.example.weather.exception.TechnicalException;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.http.ResponseEntity;


@Tag(name = "/current", description = "Servicio para gestionar información meteorológica actual de una ubicacion.")
public interface WeatherCurrentController {

    @Operation(summary  = "Obtiene la información meteorológica actual basada en la clave de ubicación proporcionada.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "success",
                    content = @Content(schema = @Schema(implementation = WeatherResDTO.class))),
            @ApiResponse(responseCode = "500",
                    description = "Internal Server Error",
                       content  =  @Content)})
    ResponseEntity<WeatherResDTO> getCurrentByLocationKey(WeatherRqDTO rq) throws TechnicalException;

    @Operation(summary = "Obtiene el historial de información meteorológica actual consultadas.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                          description = "success",
                              content = @Content(schema = @Schema(implementation = WeatherHistoryResDTO.class))),
            @ApiResponse(responseCode = "500",
                          description = "Internal Server Error",
                             content  =  @Content)})
    ResponseEntity<WeatherHistoryResDTO> getWeatherCurrentHistory() throws TechnicalException;
}
