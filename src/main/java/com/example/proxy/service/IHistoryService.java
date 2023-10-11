package com.example.proxy.service;

import com.example.proxy.dto.response.WeatherHistoryResDTO;

public interface IHistoryService {
    WeatherHistoryResDTO getWeatherHistory();
}
