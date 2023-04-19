package com.example.proxy.impl;

import com.example.proxy.service.impl.CurrentConditionServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.InjectMocks;

@ExtendWith(MockitoExtension.class)
public class CurrentConditionServiceImplTest {

    @InjectMocks
    private CurrentConditionServiceImpl service;

    @Test
    public void getByLocationKeyTest(){

    }

    @Test
    public void getByLocationKeyTest_Exception(){

    }
}
