package com.example.weather.service;

import com.example.weather.dto.request.WeatherRqDTO;
import com.example.weather.dto.response.WeatherResDTO;
import com.example.weather.exception.TechnicalException;

public interface IWeatherCurrentService {
    WeatherResDTO getByLocationKey(WeatherRqDTO rq) throws TechnicalException;
}
