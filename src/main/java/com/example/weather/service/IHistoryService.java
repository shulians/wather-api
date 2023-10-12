package com.example.weather.service;

import com.example.weather.dto.response.WeatherHistoryResDTO;
import com.example.weather.exception.TechnicalException;

public interface IHistoryService {
    WeatherHistoryResDTO getWeatherHistory() throws TechnicalException;
}
