package com.example.weather.service.impl;

import com.example.weather.dto.response.WeatherCurrentResDTO;
import com.example.weather.dto.response.WeatherHistoryResDTO;
import com.example.weather.exampledb.model.WeatherCurrentHistory;
import com.example.weather.exampledb.repository.WeatherCurrentHistoryRepository;
import com.example.weather.exception.TechnicalException;
import com.example.weather.service.IHistoryService;
import com.example.weather.util.ErrorDescriptionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HistoryServiceImpl implements IHistoryService {
    private WeatherCurrentHistoryRepository repository;
    @Autowired
    public HistoryServiceImpl(WeatherCurrentHistoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public WeatherHistoryResDTO getWeatherHistory() throws TechnicalException {
        WeatherHistoryResDTO response = WeatherHistoryResDTO.builder().build();
        List<WeatherCurrentResDTO> list = new ArrayList<>();

        try {
            List<WeatherCurrentHistory> weatherCurrentList = repository.findAll();

            if (!weatherCurrentList.isEmpty()) {
                weatherCurrentList.forEach(item -> list.add(WeatherCurrentResDTO.convert(item)));
                response.setWeathers(list);
            }

        }catch (Exception e){
            throw new TechnicalException(ErrorDescriptionUtil.E_GENERAL_EXCEPTION_CODE,
                    ErrorDescriptionUtil.E_GENERAL_EXCEPTION);
        }

        return response;
    }
}
