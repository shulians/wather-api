package com.example.proxy.service;

import com.example.proxy.dto.response.LocationResDTO;
import com.example.proxy.exception.TechnicalException;

import java.util.List;

public interface ILocationService {
    List<LocationResDTO> getLocations(String q)throws TechnicalException;

    LocationResDTO getLocationByKey(String key)throws TechnicalException;
}
