package com.example.proxy.controller;

import com.example.proxy.dto.response.LocationResDTO;
import com.example.proxy.exception.TechnicalException;
import com.example.proxy.service.ILocationService;
import com.example.proxy.util.TestUtil;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class LocationControllerTest {

    @InjectMocks
    private LocationController controller;

    @Mock
    private ILocationService service;

    @Test
    void getLocationByLocalizedNameTest() throws TechnicalException {
        LocationResDTO location = TestUtil.getLocationResDTO();

        when(service.getLocation(TestUtil.LOCATIONS_LOCALIZED_NAME)).thenReturn(location);

        Assert.assertEquals(controller.getLocationByLocalizedName(TestUtil.LOCATIONS_LOCALIZED_NAME).getBody(), location);
    }

}
