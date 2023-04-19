package com.example.proxy.service.impl;

import com.example.proxy.dto.response.LocationResDTO;
import com.example.proxy.feign.client.locations.LocationsClient;
import com.example.proxy.service.ILocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class LocationServiceImpl implements ILocationService {
    @Value("${feign.accuweather.apikey}")
    String apiKey;

    LocationsClient client;

    @Autowired
    public LocationServiceImpl(LocationsClient client) {
        this.client = client;
    }

    @Override
    public LocationResDTO getLocation(String q) {
        client.searchByQ(apiKey,q);
        return null;
    }
}
