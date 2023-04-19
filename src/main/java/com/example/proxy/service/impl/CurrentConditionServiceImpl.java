package com.example.proxy.service.impl;

import com.example.proxy.dto.TemperatureDTO;
import com.example.proxy.dto.response.CurrentConditionResDTO;
import com.example.proxy.exception.TechnicalException;
import com.example.proxy.feign.client.currentconditions.CurrentConditionsClient;
import com.example.proxy.feign.rest.currentconditions.CurrentConditions;
import com.example.proxy.feign.rest.currentconditions.MeasureTime;
import com.example.proxy.service.ICurrentConditionService;
import com.example.proxy.util.ErrorDescriptionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurrentConditionServiceImpl implements ICurrentConditionService {
    @Value("${feign.accuweather.apikey}")
    String apiKey;

    CurrentConditionsClient client;

    @Autowired
    public CurrentConditionServiceImpl(CurrentConditionsClient client) {
        this.client = client;
    }

    @Override
    public CurrentConditionResDTO getByLocationKey(String locationKey)throws TechnicalException{
        CurrentConditionResDTO response = null;

        try {
            List<CurrentConditions> conditions = client.getByLocationKey(apiKey, locationKey);

            if(!conditions.isEmpty()){
                CurrentConditions condition = conditions.get(0);
                response = CurrentConditionResDTO.convert(condition);
            }
        }catch (Exception e){
            throw new TechnicalException(ErrorDescriptionUtil.E_GENERAL_EXCEPTION_CODE,
                                            ErrorDescriptionUtil.E_GENERAL_EXCEPTION);
        }

        return response;
    }
}
