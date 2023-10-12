package com.example.weather.service.impl;

import com.example.weather.dto.response.LocationResDTO;
import com.example.weather.dto.response.WeatherHistoryResDTO;
import com.example.weather.dto.response.WeatherResDTO;
import com.example.weather.exception.TechnicalException;
import com.example.weather.feign.client.result.ResultClient;
import com.example.weather.feign.rest.locations.Locations;
import com.example.weather.feign.rest.result.Results;
import com.example.weather.service.IHistoryService;
import com.example.weather.util.ErrorDescriptionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HistoryServiceImpl implements IHistoryService {
    ResultClient resultsClient;

    @Autowired
    public HistoryServiceImpl(ResultClient resultsClient) {
        this.resultsClient = resultsClient;
    }

    @Override
    public WeatherHistoryResDTO getWeatherHistory() throws TechnicalException {
        WeatherHistoryResDTO response = WeatherHistoryResDTO.builder().build();
        List<WeatherResDTO> list = new ArrayList<>();

        try {
            Results results = resultsClient.getAll();

            if (!results.getResults().isEmpty()) {
                results.getResults().forEach(item -> list.add(WeatherResDTO.convert(item)));
                response.setWeathers(list);
            }

        }catch (Exception e){
            throw new TechnicalException(ErrorDescriptionUtil.E_GENERAL_EXCEPTION_CODE,
                    ErrorDescriptionUtil.E_GENERAL_EXCEPTION);
        }

        return response;
    }
}
