package com.example.weather.controller;

import com.example.weather.dto.response.LocationResDTO;
import com.example.weather.exception.TechnicalException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


public interface LocationController {


    ResponseEntity<List<LocationResDTO>> getLocationByLocalizedName(@RequestParam("localizedName")String localizedName) throws TechnicalException;



    ResponseEntity<LocationResDTO> getLocationByKey(@PathVariable("key")String key) throws TechnicalException;
}
