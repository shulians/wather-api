package com.example.proxy.service.impl;

import com.example.proxy.dto.response.WeatherResDTO;
import com.example.proxy.exception.TechnicalException;
import com.example.proxy.feign.client.currentconditions.CurrentConditionsClient;
import com.example.proxy.feign.rest.currentconditions.CurrentConditions;
import com.example.proxy.service.IWeatherCurrentService;
import com.example.proxy.util.ErrorDescriptionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeatherCurrentServiceImpl implements IWeatherCurrentService {
    @Value("${feign.accuweather.apikey}")
    String apiKey;

    CurrentConditionsClient client;

    @Autowired
    public WeatherCurrentServiceImpl(CurrentConditionsClient client) {
        this.client = client;
    }

    @Override
    public WeatherResDTO getByLocationKey(String locationKey)throws TechnicalException{
        WeatherResDTO response = null;

        try {
            List<CurrentConditions> conditions = client.getByLocationKey(apiKey, locationKey);

            if(!conditions.isEmpty()){
                CurrentConditions condition = conditions.get(0);
                response = WeatherResDTO.convert(condition);
            }
        }catch (Exception e){
            throw new TechnicalException(ErrorDescriptionUtil.E_GENERAL_EXCEPTION_CODE,
                                            ErrorDescriptionUtil.E_GENERAL_EXCEPTION);
        }

        return response;
    }
}
