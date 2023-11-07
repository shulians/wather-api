package com.example.weather.controller;

import com.example.weather.dto.response.LocationResDTO;
import com.example.weather.exception.TechnicalException;
import io.swagger.annotations.*;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "/location",tags = {"Location - Service"}, description = "Servicio para obtener informacion detallada de una ubicación.")
public interface LocationController {

    @ApiOperation(value = "Obtiene la lista de ubicaciones por localizedName.",
            httpMethod = "GET",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200,
                    message = "success",
                    response = LocationResDTO.class, responseContainer = "List"),
            @ApiResponse(code = 500,
                    message = "Internal Server Error")})
    ResponseEntity<List<LocationResDTO>> getLocationByLocalizedName(@ApiParam(name  = "localizedName",
            required = true, type = "String",example = "Luis Guillon",  value = "Esta propiedad se utiliza para especificar el nombre de la ciudad o área para la cual deseas obtener información meteorológica")@RequestParam("localizedName")String localizedName) throws TechnicalException;

    @ApiOperation(value = "Obtiene la ubicación por clave.",
            httpMethod = "GET",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200,
                    message = "success",
                    response = LocationResDTO.class),
            @ApiResponse(code = 500,
                    message = "Internal Server Error")})
    ResponseEntity<LocationResDTO> getLocationByKey(@PathVariable("key")String key) throws TechnicalException;
}
