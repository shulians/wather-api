package com.example.proxy.impl;

import com.example.proxy.dto.response.LocationResDTO;
import com.example.proxy.exception.TechnicalException;
import com.example.proxy.feign.client.locations.LocationsClient;
import com.example.proxy.feign.rest.locations.Locations;
import com.example.proxy.service.impl.LocationServiceImpl;
import com.example.proxy.util.TestUtil;
import org.junit.Assert;
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

        String key = TestUtil.KEY;
        List<Locations> locations = TestUtil.getListLocations();

        when(client.searchByQ(TestUtil.API_KEY_VALUE,TestUtil.TEXT)).thenReturn(locations);

        LocationResDTO response = service.getLocation(TestUtil.TEXT);

        Assert.assertEquals(response.getKey(), key);
    }

    @Test
    public void getLocationTest_Exception(){
        ReflectionTestUtils.setField(service, TestUtil.API_KEY, TestUtil.API_KEY_VALUE);

        when(client.searchByQ(TestUtil.API_KEY_VALUE,TestUtil.TEXT)).thenReturn(null);

        assertThrows(TechnicalException.class, () -> service.getLocation(TestUtil.TEXT));
    }
}
