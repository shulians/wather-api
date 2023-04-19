package com.example.proxy.controller;

import com.example.proxy.service.ICurrentConditionService;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.InjectMocks;

@ExtendWith(MockitoExtension.class)
public class CurrentConditionControllerTest {

    @InjectMocks
    private CurrentConditionController controller;

    @Mock
    private ICurrentConditionService service;

}
