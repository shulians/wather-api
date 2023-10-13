package com.example.weather.controller;

import com.example.weather.dto.response.LocationResDTO;
import com.example.weather.exception.TechnicalException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "/location", description = "Controlador para manejar obtener informacion detallada de una ubicación")
public interface LocationController {

    @ApiOperation(value = "Obtiene la lista de ubicaciones por nombre localizado.",
            httpMethod = "GET",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200,
                    message = "ResponseEntity que contiene la lista de ubicaciones",
                    response = LocationResDTO.class, responseContainer = "List"),
            @ApiResponse(code = 500,
                    message = "Error tecnico generico",
                    response = TechnicalException.class)})
    ResponseEntity<List<LocationResDTO>> getLocationByLocalizedName(@RequestParam("localizedName")String localizedName) throws TechnicalException;


    @ApiOperation(value = "Obtiene la ubicación por clave.",
            httpMethod = "GET",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200,
                    message = "ResponseEntity que contiene la ubicación.",
                    response = LocationResDTO.class, responseContainer = "List"),
            @ApiResponse(code = 500,
                    message = "Error tecnico generico",
                    response = TechnicalException.class)})
    ResponseEntity<LocationResDTO> getLocationByKey(@PathVariable("key")String key) throws TechnicalException;
}
