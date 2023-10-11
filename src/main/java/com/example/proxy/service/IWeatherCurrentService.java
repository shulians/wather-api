package com.example.proxy.service;

import com.example.proxy.dto.response.WeatherResDTO;
import com.example.proxy.exception.TechnicalException;

public interface IWeatherCurrentService {
    WeatherResDTO getByLocationKey(String locationKey) throws TechnicalException;
}
