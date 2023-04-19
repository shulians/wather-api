package com.example.proxy.service.impl;

import com.example.proxy.dto.response.CurrentConditionResDTO;
import com.example.proxy.feign.client.currentconditions.CurrentConditionsClient;
import com.example.proxy.service.ICurrentConditionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class CurrentConditionServiceImpl implements ICurrentConditionService {
    @Value("${feign.accuweather.apikey}")
    String apiKey;

    CurrentConditionsClient client;

    @Autowired
    public CurrentConditionServiceImpl(CurrentConditionsClient client) {
        this.client = client;
    }

    @Override
    public CurrentConditionResDTO getByLocationKey(String locationKey) {
        client.getByLocationKey(apiKey, locationKey);
        return null;
    }
}
