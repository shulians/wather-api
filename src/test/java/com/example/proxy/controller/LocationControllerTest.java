package com.example.proxy.controller;

import com.example.proxy.service.ILocationService;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class LocationControllerTest {

    @InjectMocks
    private LocationController controller;

    @Mock
    private ILocationService service;

}
