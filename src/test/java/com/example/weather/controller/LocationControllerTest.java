package com.example.weather.controller;

import com.example.weather.dto.response.LocationResDTO;
import com.example.weather.exception.TechnicalException;
import com.example.weather.service.ILocationService;
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
public class LocationControllerTest {

    @InjectMocks
    private LocationController controller;

    @Mock
    private ILocationService service;

    @Test
    void getLocationByLocalizedNameTest() throws TechnicalException {
        List<LocationResDTO> location = TestUtil.getLocationsResDTO();

        when(service.getLocations(TestUtil.LOCATIONS_LOCALIZED_NAME)).thenReturn(location);

        Assert.assertEquals(controller.getLocationByLocalizedName(TestUtil.LOCATIONS_LOCALIZED_NAME).getBody(), location);
    }

    @Test
    void getLocationByKeyTest() throws TechnicalException {
        LocationResDTO location = TestUtil.getLocationResDTO();

        when(service.getLocationByKey(TestUtil.KEY)).thenReturn(location);

        Assert.assertEquals(controller.getLocationByKey(TestUtil.KEY).getBody(), location);
    }

}
