package com.example.weather.controller;

import com.example.weather.dto.response.LocationResDTO;
import com.example.weather.exception.TechnicalException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "/location", description = "Servicio para obtener informacion detallada de una ubicación")
public interface LocationController {

    @Operation(summary  = "Obtiene la lista de ubicaciones por nombre.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                          description = "success",
                              content = {@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = LocationResDTO.class)))}),
            @ApiResponse(responseCode = "500",
                          description = "Internal Server Error",
                             content  =  @Content)})
    ResponseEntity<List<LocationResDTO>> getLocationByLocalizedName(@RequestParam("localizedName")String localizedName) throws TechnicalException;


    @Operation(summary = "Obtiene la ubicación por clave.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                          description = "success",
                              content = @Content(schema = @Schema(implementation = LocationResDTO.class))),
            @ApiResponse(responseCode = "500",
                          description = "Internal Server Error",
                             content  =  @Content)})
    ResponseEntity<LocationResDTO> getLocationByKey(@PathVariable("key")String key) throws TechnicalException;
}
