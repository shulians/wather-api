package com.example.weather.controller;

import com.example.weather.dto.request.WeatherRqDTO;
import com.example.weather.dto.response.WeatherHistoryResDTO;
import com.example.weather.dto.response.WeatherResDTO;
import com.example.weather.exception.TechnicalException;
import com.example.weather.service.IHistoryService;
import com.example.weather.service.IWeatherCurrentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/current")
public class WeatherCurrentController {
    IWeatherCurrentService service;

    IHistoryService historyService;

    @Autowired
    public WeatherCurrentController(IWeatherCurrentService service, IHistoryService historyService) {
        this.service = service;
        this.historyService = historyService;
    }

    @PostMapping
    public ResponseEntity<WeatherResDTO> getCurrentByLocationKey(@RequestBody WeatherRqDTO rq) throws TechnicalException {
        return ResponseEntity.ok(service.getByLocationKey(rq));
    }

    @GetMapping("/history")
    public ResponseEntity<WeatherHistoryResDTO> getWeatherCurrentHistory() throws TechnicalException {
        return ResponseEntity.ok(historyService.getWeatherHistory());
    }
}