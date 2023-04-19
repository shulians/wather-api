package com.example.proxy.service;

import com.example.proxy.dto.response.LocationResDTO;

public interface ILocationService {
    LocationResDTO getLocation(String q);
}
