package com.example.proxy.controller;

import com.example.proxy.dto.response.CurrentConditionResDTO;
import com.example.proxy.dto.response.LocationResDTO;
import com.example.proxy.exception.TechnicalException;
import com.example.proxy.service.ILocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/location")
public class LocationController {
    ILocationService service;

    @Autowired
    public LocationController(ILocationService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<LocationResDTO> getCurrentConditionByLocationKey(@RequestParam("localizedName")String localizedName) throws TechnicalException {
        return ResponseEntity.ok(service.getLocation(localizedName));
    }
}
