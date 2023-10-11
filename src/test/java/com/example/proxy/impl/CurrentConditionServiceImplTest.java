package com.example.proxy.impl;

import com.example.proxy.dto.response.WeatherResDTO;
import com.example.proxy.exception.TechnicalException;
import com.example.proxy.feign.client.currentconditions.CurrentConditionsClient;
import com.example.proxy.feign.rest.currentconditions.CurrentConditions;
import com.example.proxy.service.impl.WeatherCurrentServiceImpl;
import com.example.proxy.util.TestUtil;
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

        WeatherResDTO response = service.getByLocationKey(TestUtil.KEY);

        Assert.assertEquals(response.getTemperature().getImperial().getValue(), valueImperial);
    }

    @Test
    public void getByLocationKeyTest_Exception(){
        ReflectionTestUtils.setField(service, TestUtil.API_KEY, TestUtil.API_KEY_VALUE);

        when(client.getByLocationKey(TestUtil.API_KEY_VALUE, TestUtil.KEY)).thenReturn(null);

        assertThrows(TechnicalException.class, () -> service.getByLocationKey(TestUtil.KEY));
    }
}
