package com.example.weather.service.impl;

import com.example.weather.dto.request.WeatherRqDTO;
import com.example.weather.dto.response.WeatherResDTO;
import com.example.weather.exampledb.model.WeatherCurrentHistory;
import com.example.weather.exampledb.repository.WeatherCurrentHistoryRepository;
import com.example.weather.exception.TechnicalException;
import com.example.weather.feign.client.currentconditions.CurrentConditionsClient;
import com.example.weather.feign.rest.currentconditions.CurrentConditions;
import com.example.weather.service.IWeatherCurrentService;
import com.example.weather.util.ErrorDescriptionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeatherCurrentServiceImpl implements IWeatherCurrentService {
    @Value("${feign.accuweather.apikey}")
    String apiKey;
    CurrentConditionsClient client;
    WeatherCurrentHistoryRepository repository;

    @Autowired
    public WeatherCurrentServiceImpl(CurrentConditionsClient client, WeatherCurrentHistoryRepository repository) {
        this.client = client;
        this.repository = repository;
    }

    @Override
    public WeatherResDTO getByLocationKey(WeatherRqDTO rq)throws TechnicalException{
        WeatherResDTO response = WeatherResDTO.builder().build();

        try {
            List<CurrentConditions> conditions = client.getByLocationKey(apiKey, rq.getKey());

            if(!conditions.isEmpty()){
                CurrentConditions condition = conditions.get(0);
                response = WeatherResDTO.convert(condition);

                WeatherCurrentHistory weatherCurrent = WeatherCurrentHistory.builder()
                        .key(rq.getKey())
                        .dateTime(response.getLocalObservationDateTime())
                        .weatherInMetric(response.getTemperature().getMetric().getValue())
                        .weatherInImperial(response.getTemperature().getImperial().getValue())
                        .build();

                repository.save(weatherCurrent);
            }
        }catch (Exception e){
            throw new TechnicalException(ErrorDescriptionUtil.E_GENERAL_EXCEPTION_CODE,
                                            ErrorDescriptionUtil.E_GENERAL_EXCEPTION);
        }

        return response;
    }
}