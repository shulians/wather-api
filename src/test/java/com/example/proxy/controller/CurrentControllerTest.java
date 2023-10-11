package com.example.proxy.controller;

import com.example.proxy.dto.response.WeatherResDTO;
import com.example.proxy.exception.TechnicalException;
import com.example.proxy.service.IWeatherCurrentService;
import com.example.proxy.util.TestUtil;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.InjectMocks;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CurrentControllerTest {

    @InjectMocks
    private WeatherCurrentController controller;

    @Mock
    private IWeatherCurrentService service;

    @Test
    void getCurrentConditionByLocationKey() throws TechnicalException {
        WeatherResDTO condition = TestUtil.getWeatherCurrentResDTO();

        when(service.getByLocationKey(TestUtil.KEY)).thenReturn(condition);

        Assert.assertEquals(controller.getCurrentByLocationKey(TestUtil.KEY).getBody(), condition);
    }

}
