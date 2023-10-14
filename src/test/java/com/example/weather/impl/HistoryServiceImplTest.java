package com.example.weather.impl;

import com.example.weather.dto.response.WeatherHistoryResDTO;
import com.example.weather.dto.response.WeatherResDTO;
import com.example.weather.exampledb.model.WeatherCurrentHistory;
import com.example.weather.exampledb.repository.WeatherCurrentHistoryRepository;
import com.example.weather.exception.TechnicalException;
import com.example.weather.service.impl.HistoryServiceImpl;
import com.example.weather.util.TestUtil;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class HistoryServiceImplTest {

    @InjectMocks
    HistoryServiceImpl service;

    @Mock
    WeatherCurrentHistoryRepository repository;

    @Test
    public void getWeatherHistoryTest()throws TechnicalException {
        List<WeatherCurrentHistory> weatherCurrentList = TestUtil.getWeatherCurrentHistoryList();

        when(repository.findAll()).thenReturn(weatherCurrentList);

        Assert.assertEquals(service.getWeatherHistory().getWeathers().isEmpty(), Boolean.FALSE);
    }
}
