package com.example.proxy.impl;

import com.example.proxy.service.impl.LocationServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class LocationServiceImplTest {

    @InjectMocks
    private LocationServiceImpl service;

    @Test
    public void getLocationTest(){

    }

    @Test
    public void getLocationTest_Exception(){

    }
}
