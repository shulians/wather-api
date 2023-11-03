package com.example.weather.impl;

import com.example.weather.dto.response.LocationResDTO;
import com.example.weather.exception.TechnicalException;
import com.example.weather.feign.client.locations.LocationsClient;
import com.example.weather.feign.rest.locations.Locations;
import com.example.weather.service.impl.LocationServiceImpl;
import com.example.weather.util.TestUtil;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class LocationServiceImplTest {

    @InjectMocks
    private LocationServiceImpl service;

    @Mock
    private LocationsClient client;

    @Test
    public void getLocationTest() throws TechnicalException {
        ReflectionTestUtils.setField(service, TestUtil.API_KEY, TestUtil.API_KEY_VALUE);

        List<Locations> locations = TestUtil.getListLocations();

        when(client.searchByQ(TestUtil.API_KEY_VALUE,TestUtil.TEXT)).thenReturn(locations);

        List<LocationResDTO> response = service.getLocations(TestUtil.TEXT);

        Assertions.assertEquals(response.isEmpty(), false);
    }

    @Test
    public void getLocationTest_Exception(){
        ReflectionTestUtils.setField(service, TestUtil.API_KEY, TestUtil.API_KEY_VALUE);

        when(client.searchByQ(TestUtil.API_KEY_VALUE,TestUtil.TEXT)).thenReturn(null);

        assertThrows(TechnicalException.class, () -> service.getLocations(TestUtil.TEXT));
    }
}
