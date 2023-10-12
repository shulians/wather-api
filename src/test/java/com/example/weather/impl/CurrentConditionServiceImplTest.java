package com.example.weather.impl;

import com.example.weather.dto.response.WeatherResDTO;
import com.example.weather.exception.TechnicalException;
import com.example.weather.feign.client.currentconditions.CurrentConditionsClient;
import com.example.weather.feign.rest.currentconditions.CurrentConditions;
import com.example.weather.service.impl.WeatherCurrentServiceImpl;
import com.example.weather.util.TestUtil;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.InjectMocks;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CurrentConditionServiceImplTest {

    @InjectMocks
    private WeatherCurrentServiceImpl service;

    @Mock
    private CurrentConditionsClient client;


    @Test
    public void getByLocationKeyTest() throws TechnicalException {
        ReflectionTestUtils.setField(service, TestUtil.API_KEY, TestUtil.API_KEY_VALUE);

        Double valueImperial = TestUtil.DOUBLE_IMPERIAL;
        List<CurrentConditions> conditions = TestUtil.getListCurrentConditions();

        when(client.getByLocationKey(TestUtil.API_KEY_VALUE, TestUtil.KEY)).thenReturn(conditions);

        WeatherResDTO response = service.getByLocationKey(TestUtil.getWeatherRqDTO());

        Assert.assertEquals(response.getTemperature().getImperial().getValue(), valueImperial);
    }

    @Test
    public void getByLocationKeyTest_Exception(){
        ReflectionTestUtils.setField(service, TestUtil.API_KEY, TestUtil.API_KEY_VALUE);

        when(client.getByLocationKey(TestUtil.API_KEY_VALUE, TestUtil.KEY)).thenReturn(null);

        assertThrows(TechnicalException.class, () -> service.getByLocationKey(TestUtil.getWeatherRqDTO()));
    }
}
