package com.example.weather.controller;

import com.example.weather.dto.response.LocationResDTO;
import com.example.weather.exception.TechnicalException;
import com.example.weather.service.ILocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/location")
public class LocationController {
    ILocationService service;

    @Autowired
    public LocationController(ILocationService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<LocationResDTO>> getLocationByLocalizedName(@RequestParam("localizedName")String localizedName) throws TechnicalException {
        return ResponseEntity.ok(service.getLocations(localizedName));
    }

    @GetMapping("/{key}")
    public ResponseEntity<LocationResDTO> getLocationByKey(@PathVariable("key")String key) throws TechnicalException {
        return ResponseEntity.ok(service.getLocationByKey(key));
    }
}
