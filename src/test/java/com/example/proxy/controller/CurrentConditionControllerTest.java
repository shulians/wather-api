package com.example.proxy.controller;

import com.example.proxy.dto.response.CurrentConditionResDTO;
import com.example.proxy.dto.response.LocationResDTO;
import com.example.proxy.exception.TechnicalException;
import com.example.proxy.service.ICurrentConditionService;
import com.example.proxy.util.TestUtil;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.InjectMocks;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CurrentConditionControllerTest {

    @InjectMocks
    private CurrentConditionController controller;

    @Mock
    private ICurrentConditionService service;

    @Test
    void getCurrentConditionByLocationKey() throws TechnicalException {
        CurrentConditionResDTO condition = TestUtil.getCurrentConditionResDTO();

        when(service.getByLocationKey(TestUtil.KEY)).thenReturn(condition);

        Assert.assertEquals(controller.getCurrentConditionByLocationKey(TestUtil.KEY).getBody(), condition);
    }

}
