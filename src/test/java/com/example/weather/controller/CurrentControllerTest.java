package com.example.weather.controller;


import com.example.weather.dto.response.WeatherResDTO;
import com.example.weather.exception.TechnicalException;
import com.example.weather.service.IWeatherCurrentService;
import com.example.weather.util.TestUtil;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.InjectMocks;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CurrentControllerTest {
/*
    @InjectMocks
    private WeatherCurrentController controller;

    @Mock
    private IWeatherCurrentService service;

    @Test
    void getCurrentConditionByLocationKey() throws TechnicalException {
        WeatherResDTO condition = TestUtil.getWeatherCurrentResDTO();

        when(service.getByLocationKey(TestUtil.getWeatherRqDTO())).thenReturn(condition);

        Assert.assertEquals(controller.getCurrentByLocationKey(TestUtil.getWeatherRqDTO()).getBody(), condition);
    }
*/
}
