package com.example.proxy.service;

import com.example.proxy.dto.response.LocationResDTO;
import com.example.proxy.exception.TechnicalException;

public interface ILocationService {
    LocationResDTO getLocation(String q)throws TechnicalException;
}
