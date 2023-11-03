package com.example.weather.controller;

import com.example.weather.dto.request.WeatherRqDTO;
import com.example.weather.dto.response.WeatherHistoryResDTO;
import com.example.weather.dto.response.WeatherResDTO;
import com.example.weather.exception.TechnicalException;

import org.springframework.http.ResponseEntity;



public interface WeatherCurrentController {


    ResponseEntity<WeatherResDTO> getCurrentByLocationKey(WeatherRqDTO rq) throws TechnicalException;


    ResponseEntity<WeatherHistoryResDTO> getWeatherCurrentHistory() throws TechnicalException;
}
