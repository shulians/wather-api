package com.example.weather.service;

import com.example.weather.dto.response.LocationResDTO;
import com.example.weather.exception.TechnicalException;

import java.util.List;

public interface ILocationService {
    List<LocationResDTO> getLocations(String q)throws TechnicalException;

    LocationResDTO getLocationByKey(String key)throws TechnicalException;
}
