package com.example.proxy.controller;

import com.example.proxy.dto.response.WeatherResDTO;
import com.example.proxy.exception.TechnicalException;
import com.example.proxy.service.IWeatherCurrentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/current")
public class WeatherCurrentController {
    IWeatherCurrentService service;

    @Autowired
    public WeatherCurrentController(IWeatherCurrentService service) {
        this.service = service;
    }

    @GetMapping("/{locationKey}")
    public ResponseEntity<WeatherResDTO> getCurrentByLocationKey(@PathVariable("locationKey") String locationKey) throws TechnicalException {
        return ResponseEntity.ok(service.getByLocationKey(locationKey));
    }
}